package net.mguenther.todo.persistence.jpa.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TODO_LIST_ITEM")
public class TodoListItemEntity implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private String itemId;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "DUE")
    private LocalDateTime due;

    @Column(name = "CREATED", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "LAST_MODIFIED", nullable = false)
    private LocalDateTime lastModified;

    @Column(name = "CLOSED_AT")
    private LocalDateTime closedAt;

    @Column(name = "CLOSED")
    private Boolean closed;

    @Column(name = "LIST_ID")
    private String listId;

    protected TodoListItemEntity() {
    }

    public TodoListItemEntity(final String itemId,
                              final String description,
                              final LocalDateTime due,
                              final LocalDateTime created,
                              final LocalDateTime lastModified,
                              final LocalDateTime closedAt,
                              final Boolean closed,
                              final String listId) {
        this.itemId = itemId;
        this.description = description;
        this.due = due;
        this.created = created;
        this.lastModified = lastModified;
        this.closedAt = closedAt;
        this.closed = closed;
        this.listId = listId;
    }

    public String getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public Boolean getClosed() {
        return closed;
    }

    public String getListId() {
        return listId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoListItemEntity that = (TodoListItemEntity) o;
        return Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "TodoListItemEntity{" +
                "itemId='" + itemId + '\'' +
                ", description='" + description + '\'' +
                ", due=" + due +
                ", created=" + created +
                ", lastModified=" + lastModified +
                ", closedAt=" + closedAt +
                ", closed=" + closed +
                ", listId='" + listId + '\'' +
                '}';
    }
}
