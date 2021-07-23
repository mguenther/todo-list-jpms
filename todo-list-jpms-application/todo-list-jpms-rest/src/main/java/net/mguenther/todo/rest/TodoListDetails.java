package net.mguenther.todo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TodoListDetails {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("created")
    private String created;

    @JsonProperty("lastModified")
    private String lastModified;

    @JsonProperty("items")
    @Valid
    private List<TodoItemOverview> items = null;

    public TodoListDetails id(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TodoListDetails name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TodoListDetails description(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoListDetails created(String created) {
        this.created = created;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public TodoListDetails lastModified(String lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public TodoListDetails items(List<TodoItemOverview> items) {
        this.items = items;
        return this;
    }

    public TodoListDetails addItemsItem(TodoItemOverview itemsItem) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(itemsItem);
        return this;
    }

    @Valid
    public List<TodoItemOverview> getItems() {
        return items;
    }

    public void setItems(List<TodoItemOverview> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TodoListDetails todoListDetails = (TodoListDetails) o;
        return Objects.equals(this.id, todoListDetails.id) &&
                Objects.equals(this.name, todoListDetails.name) &&
                Objects.equals(this.description, todoListDetails.description) &&
                Objects.equals(this.created, todoListDetails.created) &&
                Objects.equals(this.lastModified, todoListDetails.lastModified) &&
                Objects.equals(this.items, todoListDetails.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created, lastModified, items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TodoListDetails {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}