package net.mguenther.todo.persistence.jpa.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

@Entity
@Table(name = "TODO_LIST")
public class TodoListEntity implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private String listId;

    @Column(name = "LIST_NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "LAST_MODIFIED", nullable = false)
    private LocalDateTime lastModified;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "LIST_ID")
    private Set<TodoListItemEntity> items;

    protected TodoListEntity() {
    }

    public TodoListEntity(final String listId,
                          final String name,
                          final String description,
                          final LocalDateTime created,
                          final LocalDateTime lastModified,
                          final Set<TodoListItemEntity> items) {
        this.listId = listId;
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
        this.items = new HashSet<>();
        this.items.addAll(items);
    }

    public String getListId() {
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

    public Stream<TodoListItemEntity> getItems() {
        return items.stream();
    }

    public void update(final String name,
                       final String description,
                       final LocalDateTime lastModified,
                       final Set<TodoListItemEntity> items) {
        this.name = name;
        this.description = description;
        this.lastModified = lastModified;
        this.items.clear();
        this.items.addAll(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoListEntity that = (TodoListEntity) o;
        return Objects.equals(listId, that.listId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId);
    }

    @Override
    public String toString() {
        return "TodoListEntity{" +
                "listId='" + listId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", lastModified=" + lastModified +
                '}';
    }
}
