package net.mguenther.todo.domain;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface TodoListRepository {

    Set<TodoList> findAll();

    TodoList save(TodoList todoList);

    void delete(UUID uuid);

    Optional<TodoList> findById(UUID uuid);
}
