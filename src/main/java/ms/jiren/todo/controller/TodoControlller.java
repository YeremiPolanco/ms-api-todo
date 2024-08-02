package ms.jiren.todo.controller;

import lombok.RequiredArgsConstructor;
import ms.jiren.todo.repository.entity.Todo;
import ms.jiren.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoControlller {
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Todo> getById(@PathVariable int id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        Todo savedTodo = todoService.save(todo);
        return ResponseEntity.created(URI.create("/api/todo/" + savedTodo.getId())).body(savedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Todo>> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(todoService.getAllByTitle(title));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Todo>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(todoService.getAllByStatus(status));
    }
}
