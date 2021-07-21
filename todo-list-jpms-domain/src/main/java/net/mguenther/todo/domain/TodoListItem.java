package net.mguenther.todo.domain;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class TodoListItem {

    private final UUID itemId;

    private String description;

    private LocalDateTime due;

    private LocalDateTime created;

    private LocalDateTime lastModified;

    private LocalDateTime closedAt;

    private boolean closed;

    public TodoListItem(final String description, final LocalDateTime due) {
        this.itemId = UUID.randomUUID();
        this.description = description;
        this.due = due;
        this.created = LocalDateTime.now(Clock.systemUTC());
        this.lastModified = LocalDateTime.now(Clock.systemUTC());
    }

    public TodoListItem(final UUID itemId,
                        final String description,
                        final LocalDateTime due,
                        final LocalDateTime created,
                        final LocalDateTime lastModified,
                        final LocalDateTime closedAt,
                        final boolean closed) {
        this.itemId = itemId;
        this.description = description;
        this.due = due;
        this.created = created;
        this.lastModified = lastModified;
        this.closedAt = closedAt;
        this.closed = closed;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public void setDue(LocalDateTime due) {
        this.due = due;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public boolean isClosed() {
        return closed;
    }

    public void describe(final String description) {
        this.description = description;
        this.lastModified = LocalDateTime.now(Clock.systemUTC());
    }

    public void close() {
        this.closed = true;
        this.closedAt = LocalDateTime.now(Clock.systemUTC());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoListItem that = (TodoListItem) o;
        return Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "TodoListItem{" +
                "itemId=" + itemId +
                ", description='" + description + '\'' +
                '}';
    }
}
