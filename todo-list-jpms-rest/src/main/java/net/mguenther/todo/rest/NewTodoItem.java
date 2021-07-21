package net.mguenther.todo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class NewTodoItem   {

    @JsonProperty("description")
    private String description;

    @JsonProperty("due")
    private String due;

    public NewTodoItem description(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NewTodoItem due(String due) {
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
        NewTodoItem newTodoItem = (NewTodoItem) o;
        return Objects.equals(this.description, newTodoItem.description) &&
                Objects.equals(this.due, newTodoItem.due);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, due);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewTodoItem {\n");
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
