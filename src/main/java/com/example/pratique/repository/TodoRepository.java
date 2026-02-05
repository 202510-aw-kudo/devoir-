package com.example.pratique.repository;

import com.example.pratique.entity.Todo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {
  List<Todo> findByCompleted(Boolean completed);

  List<Todo> findByTitleContainingIgnoreCase(String keyword);

  List<Todo> findByDueDateLessThanEqual(LocalDate date);

  List<Todo> findAllByOrderByPriorityAsc();

  @Query("select t from Todo t where t.completed = :completed and t.title like %:keyword%")
  List<Todo> searchByStatusAndTitleLike(
      @Param("completed") Boolean completed, @Param("keyword") String keyword);
}
