package net.mguenther.todo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TodoItemOverview {

    @JsonProperty("id")
    private String id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("due")
    private String due;

    public TodoItemOverview id(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TodoItemOverview description(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoItemOverview due(String due) {
        this.due = due;
        return this;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TodoItemOverview todoItemOverview = (TodoItemOverview) o;
        return Objects.equals(this.id, todoItemOverview.id) &&
                Objects.equals(this.description, todoItemOverview.description) &&
                Objects.equals(this.due, todoItemOverview.due);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, due);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TodoItemOverview {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    due: ").append(toIndentedString(due)).append("\n");
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

