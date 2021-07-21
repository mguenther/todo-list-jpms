package net.mguenther.todo.domain;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public interface TodoListService {

    TodoList createTodoList(final String name, final String description);

    TodoListItem createTodoListItem(final UUID todoListId, final String description, final LocalDateTime due);

    void close(final UUID todoListId, final UUID todoListItemId);

    Set<TodoList> getTodoLists();

    TodoList getTodoList(final UUID todoListId);

    TodoListItem getTodoListItem(final UUID todoListId, final UUID todoListItemId);
}
