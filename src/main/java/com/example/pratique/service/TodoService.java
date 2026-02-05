package com.example.pratique.service;

import com.example.pratique.entity.Todo;
import com.example.pratique.form.TodoForm;
import com.example.pratique.repository.TodoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
  private final TodoRepository todoRepository;

  public List<Todo> findAll() {
    return todoRepository.findAll();
  }

  public List<Todo> findAllSortedByCreatedAtDesc() {
    return todoRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
  }

  public Todo create(TodoForm form) {
    Todo todo = toEntity(form);
    return todoRepository.save(todo);
  }

  private Todo toEntity(TodoForm form) {
    return Todo.builder()
        .title(form.getTitle())
        .description(form.getDescription())
        .dueDate(form.getDueDate())
        .priority(form.getPriority())
        .build();
  }
}
