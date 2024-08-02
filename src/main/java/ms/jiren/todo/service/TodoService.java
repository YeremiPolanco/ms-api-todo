package ms.jiren.todo.service;

import lombok.RequiredArgsConstructor;
import ms.jiren.todo.repository.dao.TodoDao;
import ms.jiren.todo.repository.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoDao todoDao;

    public List<Todo> getAll() {
        return todoDao.findAll();
    }

    public Todo getById(int id) {
        return todoDao.findById(id).orElse(null);
    }

    public Todo save(Todo todo) {
        return todoDao.save(todo);
    }

    public Todo update(int id, Todo todo) {
        Todo todoUpdated = getById(id);
        Todo.builder()
                .title(todo.getTitle())
                .status(todo.getStatus())
                .build();
        return todoDao.save(todoUpdated);
    }

    public void delete(int id) {
        todoDao.deleteById(id);
    }

    public List<Todo> getAllByStatus(String status) {
        return todoDao.findAllByStatus(status);
    }

    public List<Todo> getAllByTitle(String title) {
        return todoDao.findAllByTitle(title);
    }
}
