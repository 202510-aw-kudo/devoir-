package com.example.pratique.controller;

import com.example.pratique.entity.Todo;
import com.example.pratique.form.TodoForm;
import com.example.pratique.service.TodoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;

  // ToDo一覧画面を表示する。
  @GetMapping("/todos")
  public String list(Model model) {
    List<Todo> todos = todoService.findAllSortedByCreatedAtDesc();
    model.addAttribute("todos", todos);
    return "todos/list";
  }

  // ToDo新規作成画面を表示する。
  @GetMapping("/todos/new")
  public String newForm(Model model) {
    model.addAttribute("todoForm", new TodoForm());
    return "todos/form";
  }

  // ToDo入力内容の確認画面を表示する。
  @PostMapping("/todos/confirm")
  public String confirm(@ModelAttribute TodoForm form, Model model) {
    model.addAttribute("title", form.getTitle());
    model.addAttribute("description", form.getDescription());
    model.addAttribute("priority", form.getPriority());
    return "todos/confirm";
  }

  // ToDoを登録して一覧へリダイレクトする。
  @PostMapping("/todos/complete")
  public String complete(@ModelAttribute TodoForm form, RedirectAttributes redirectAttributes) {
    todoService.create(form);
    redirectAttributes.addFlashAttribute("message", "登録が完了しました");
    return "redirect:/todos";
  }

  // 指定されたIDのToDo詳細画面を表示する。
  @GetMapping("/todos/{id}")
  public String detail(@PathVariable("id") long id) {
    return "todos/detail";
  }
}
