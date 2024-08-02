package ms.jiren.todo.repository.dao;

import ms.jiren.todo.repository.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoDao extends JpaRepository<Todo, Integer> {

    @Query(value = "SELECT * FROM todo WHERE status = :status", nativeQuery = true)
    List<Todo> findAllByStatus(@Param("status") String status);

    @Query(value = "SELECT * FROM todo WHERE title LIKE %:title%", nativeQuery = true)
    List<Todo> findAllByTitle(@Param("title") String title);
}
