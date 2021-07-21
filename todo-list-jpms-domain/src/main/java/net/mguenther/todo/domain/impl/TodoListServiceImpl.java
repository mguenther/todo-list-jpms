package net.mguenther.todo.domain.impl;

import net.mguenther.todo.domain.TodoList;
import net.mguenther.todo.domain.TodoListItem;
import net.mguenther.todo.domain.TodoListRepository;
import net.mguenther.todo.domain.TodoListService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Component
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository repository;

    public TodoListServiceImpl(final TodoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public TodoList createTodoList(final String name, final String description) {
        return repository.save(new TodoList(name, description));
    }

    @Override
    public TodoListItem createTodoListItem(final UUID todoListId, final String description, final LocalDateTime due) {
        final TodoList todoList = getTodoList(todoListId);
        System.out.println(todoList.getListId());
        final TodoListItem item = todoList.create(description, due);
        repository.save(todoList);
        return item;
    }

    @Override
    public void close(final UUID todoListId, final UUID todoListItemId) {
        final TodoList todoList = getTodoList(todoListId);
        todoList.close(todoListItemId);
        repository.save(todoList);
    }

    @Override
    public Set<TodoList> getTodoLists() {
        return repository.findAll();
    }

    @Override
    public TodoList getTodoList(final UUID todoListId) {
        return repository
                .findById(todoListId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no todo list with ID '%s'.", todoListId)));
    }

    @Override
    public TodoListItem getTodoListItem(final UUID todoListId, final UUID todoListItemId) {
        return getTodoList(todoListId)
                .items()
                .filter(todoListItem -> todoListItem.getItemId().equals(todoListItemId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no todo list item with ID '%s' managed at todo list '%s'.", todoListItemId, todoListId)));
    }
}
