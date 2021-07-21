package net.mguenther.todo.domain;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

public class TodoList {

    private final UUID listId;

    private final String name;

    private String description;

    private Set<TodoListItem> items;

    private LocalDateTime created;

    private LocalDateTime lastModified;

    public TodoList(final String name, final String description) {
        this.listId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.items = new HashSet<>();
        this.created = LocalDateTime.now(Clock.systemUTC());
        this.lastModified = LocalDateTime.now(Clock.systemUTC());
    }

    public TodoList(final UUID listId,
                    final String name,
                    final String description,
                    final Set<TodoListItem> items,
                    final LocalDateTime created,
                    final LocalDateTime lastModified) {
        this.listId = listId;
        this.name = name;
        this.description = description;
        this.items = new HashSet<>();
        this.items.addAll(items);
        this.created = created;
        this.lastModified = lastModified;
    }

    public UUID getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public Stream<TodoListItem> items() {
        return items.stream();
    }

    public void describe(final String description) {
        this.description = description;
        this.lastModified = LocalDateTime.now(Clock.systemUTC());
    }

    public TodoListItem create(final String description) {
        return create(description, null);
    }

    public TodoListItem create(final String description, final LocalDateTime due) {
        var item = new TodoListItem(description, due);
        this.items.add(item);
        this.lastModified = LocalDateTime.now(Clock.systemUTC());
        return item;
    }

    public void remove(final TodoListItem item) {
        this.items.remove(item);
        this.lastModified = LocalDateTime.now(Clock.systemUTC());
    }

    public void close(final UUID todoListItemId) {
        items
                .stream()
                .filter(item -> item.getItemId().equals(todoListItemId)).findFirst()
                .ifPresent(todoListItem -> {
                    todoListItem.close();
                    lastModified = LocalDateTime.now(Clock.systemUTC());
                });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoList todoList = (TodoList) o;
        return Objects.equals(listId, todoList.listId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId);
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "listId=" + listId +
                ", name='" + name + '\'' +
                '}';
    }
}
