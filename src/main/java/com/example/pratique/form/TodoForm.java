package com.example.pratique.form;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoForm {
  private String title;
  private String description;
  private LocalDate dueDate;
  private Integer priority;
}
