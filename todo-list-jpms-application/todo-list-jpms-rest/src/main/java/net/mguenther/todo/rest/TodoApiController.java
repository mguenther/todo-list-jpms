package net.mguenther.todo.rest;

import net.mguenther.todo.domain.TodoList;
import net.mguenther.todo.domain.TodoListItem;
import net.mguenther.todo.domain.TodoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TodoApiController {

    private final TodoListService service;

    public TodoApiController(final TodoListService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/todo",
            produces = { "application/json" },
            consumes = { "application/json" })
    public ResponseEntity<TodoListDetails> createTodoList(@RequestBody @Valid final NewTodoList newTodoList) {
        final TodoList todoList = service.createTodoList(newTodoList.getName(), newTodoList.getDescription());
        final TodoListDetails todoListDetails = toDetails(todoList);
        return ResponseEntity
                .created(URI.create("/todo/" + todoList.getListId().toString()))
                .body(todoListDetails);
    }

    @PostMapping(
            value = "/todo/{listId}",
            produces = { "application/json" },
            consumes = { "application/json" })
    public ResponseEntity<TodoItemDetails> createTodoItem(@PathVariable("listId") final String listId,
                                                          @RequestBody @Valid final NewTodoItem newTodoItem) {
        final LocalDateTime due = LocalDateTime.parse(newTodoItem.getDue());
        final TodoListItem todoListItem = service.createTodoListItem(UUID.fromString(listId), newTodoItem.getDescription(), due);
        final TodoItemDetails todoItemDetails = toDetails(todoListItem);
        return ResponseEntity
                .created(URI.create("/todo/" + listId + "/" + todoListItem.getItemId().toString()))
                .body(todoItemDetails);
    }

    @GetMapping(value = "/todo", produces = { "application/json" })
    public ResponseEntity<List<TodoListOverview>> showAllTodoLists() {
        return ResponseEntity.ok(service.getTodoLists().stream().map(this::toOverview).collect(Collectors.toList()));
    }

    @GetMapping(value = "/todo/{listId}/{itemId}", produces = { "application/json" })
    public ResponseEntity<TodoItemDetails> showItem(@PathVariable("listId") final String listId,
                                                    @PathVariable("itemId") final String itemId) {
        final TodoItemDetails details = toDetails(service.getTodoListItem(
                UUID.fromString(listId),
                UUID.fromString(itemId)));
        return ResponseEntity.ok(details);
    }

    @GetMapping(value = "/todo/{listId}", produces = { "application/json" })
    public ResponseEntity<TodoListDetails> showTodoList(@PathVariable("listId") final String listId) {
        return ResponseEntity.ok(toDetails(service.getTodoList(UUID.fromString(listId))));
    }

    private TodoListDetails toDetails(final TodoList todoList) {
        final TodoListDetails details = new TodoListDetails();
        details.setId(todoList.getListId().toString());
        details.setName(todoList.getName());
        details.setDescription(todoList.getDescription());
        details.setCreated(todoList.getCreated().toString());
        details.setLastModified(todoList.getLastModified().toString());
        details.setItems(todoList.items().map(this::toOverview).collect(Collectors.toList()));
        return details;
    }

    private TodoItemDetails toDetails(final TodoListItem todoListItem) {
        final TodoItemDetails details = new TodoItemDetails();
        details.setId(todoListItem.getItemId().toString());
        details.setDescription(todoListItem.getDescription());
        details.setDue(todoListItem.getDue().toString());
        details.setCreated(todoListItem.getCreated().toString());
        details.setLastModified(todoListItem.getLastModified().toString());
        details.setClosedAt(todoListItem.getClosedAt().toString());
        details.setClosed(todoListItem.isClosed());
        return details;
    }

    private TodoListOverview toOverview(final TodoList todoList) {
        final TodoListOverview overview = new TodoListOverview();
        overview.setId(todoList.getListId().toString());
        overview.setName(todoList.getName());
        overview.setDescription(todoList.getDescription());
        return overview;
    }

    private TodoItemOverview toOverview(final TodoListItem todoListItem) {
        final TodoItemOverview overview = new TodoItemOverview();
        overview.setId(todoListItem.getItemId().toString());
        overview.setDescription(todoListItem.getDescription());
        overview.setDue(todoListItem.getDue().toString());
        return overview;
    }
}
