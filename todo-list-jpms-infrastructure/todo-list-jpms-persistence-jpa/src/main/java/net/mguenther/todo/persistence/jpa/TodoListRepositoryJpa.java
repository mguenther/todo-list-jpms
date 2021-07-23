package net.mguenther.todo.persistence.jpa;

import net.mguenther.todo.domain.TodoList;
import net.mguenther.todo.domain.TodoListItem;
import net.mguenther.todo.domain.TodoListRepository;
import net.mguenther.todo.persistence.jpa.impl.TodoListEntity;
import net.mguenther.todo.persistence.jpa.impl.TodoListEntityRepository;
import net.mguenther.todo.persistence.jpa.impl.TodoListItemEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TodoListRepositoryJpa implements TodoListRepository {

    private final TodoListEntityRepository repository;

    public TodoListRepositoryJpa(final TodoListEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<TodoList> findAll() {
        return repository.findAll().stream().map(this::convert).collect(Collectors.toSet());
    }

    @Override
    public TodoList save(final TodoList todoList) {
        final TodoListEntity entity = repository
                .findById(todoList.getListId().toString())
                .orElseGet(() -> repository.saveAndFlush(convert(todoList)));
        entity.update(
                todoList.getName(),
                todoList.getDescription(),
                todoList.getLastModified(),
                todoList.items().map(item -> convert(item, todoList.getListId())).collect(Collectors.toSet()));
        return convert(repository.saveAndFlush(entity));
    }

    @Override
    public void delete(final UUID uuid) {
        repository.deleteById(uuid.toString());
    }

    @Override
    public Optional<TodoList> findById(final UUID uuid) {
        return repository.findById(uuid.toString()).map(this::convert);
    }

    private TodoList convert(final TodoListEntity entity) {
        return new TodoList(
                UUID.fromString(entity.getListId()),
                entity.getName(),
                entity.getDescription(),
                entity.getItems().map(this::convert).collect(Collectors.toSet()),
                entity.getCreated(),
                entity.getLastModified());
    }

    private TodoListItem convert(final TodoListItemEntity entity) {
        return new TodoListItem(
                UUID.fromString(entity.getItemId()),
                entity.getDescription(),
                entity.getDue(),
                entity.getCreated(),
                entity.getLastModified(),
                entity.getClosedAt(),
                entity.getClosed());
    }

    private TodoListEntity convert(final TodoList todoList) {
        return new TodoListEntity(
                todoList.getListId().toString(),
                todoList.getName(),
                todoList.getDescription(),
                todoList.getCreated(),
                todoList.getLastModified(),
                todoList.items().map(item -> convert(item, todoList.getListId())).collect(Collectors.toSet()));
    }

    private TodoListItemEntity convert(final TodoListItem item, final UUID listId) {
        return new TodoListItemEntity(
                item.getItemId().toString(),
                item.getDescription(),
                item.getDue(),
                item.getCreated(),
                item.getLastModified(),
                item.getClosedAt(),
                item.isClosed(),
                listId.toString());
    }
}
