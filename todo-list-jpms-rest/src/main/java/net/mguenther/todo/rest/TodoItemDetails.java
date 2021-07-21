package net.mguenther.todo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TodoItemDetails {

    @JsonProperty("id")
    private String id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("due")
    private String due;

    @JsonProperty("created")
    private String created;

    @JsonProperty("lastModified")
    private String lastModified;

    @JsonProperty("closedAt")
    private String closedAt;

    @JsonProperty("closed")
    private Boolean closed;

    public TodoItemDetails id(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TodoItemDetails description(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoItemDetails due(String due) {
        this.due = due;
        return this;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public TodoItemDetails created(String created) {
        this.created = created;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public TodoItemDetails lastModified(String lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public TodoItemDetails closedAt(String closedAt) {
        this.closedAt = closedAt;
        return this;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public TodoItemDetails closed(Boolean closed) {
        this.closed = closed;
        return this;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TodoItemDetails todoItemDetails = (TodoItemDetails) o;
        return Objects.equals(this.id, todoItemDetails.id) &&
                Objects.equals(this.description, todoItemDetails.description) &&
                Objects.equals(this.due, todoItemDetails.due) &&
                Objects.equals(this.created, todoItemDetails.created) &&
                Objects.equals(this.lastModified, todoItemDetails.lastModified) &&
                Objects.equals(this.closedAt, todoItemDetails.closedAt) &&
                Objects.equals(this.closed, todoItemDetails.closed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, due, created, lastModified, closedAt, closed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TodoItemDetails {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    due: ").append(toIndentedString(due)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
        sb.append("    closedAt: ").append(toIndentedString(closedAt)).append("\n");
        sb.append("    closed: ").append(toIndentedString(closed)).append("\n");
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

