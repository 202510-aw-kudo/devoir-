package com.example.pratique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

  // ToDo一覧画面を表示する。
  @GetMapping("/todos")
  public String list() {
    return "todos/list";
  }

  // ToDo新規作成画面を表示する。
  @GetMapping("/todos/new")
  public String newForm() {
    return "todos/new";
  }

  // ToDo入力内容の確認画面を表示する。
  @PostMapping("/todos/confirm")
  public String confirm(
      @RequestParam("title") String title,
      @RequestParam(value = "description", required = false) String description,
      @RequestParam(value = "priority", defaultValue = "3") Integer priority,
      Model model) {
    model.addAttribute("title", title);
    model.addAttribute("description", description);
    model.addAttribute("priority", priority);
    return "todos/confirm";
  }

  // 指定されたIDのToDo詳細画面を表示する。
  @GetMapping("/todos/{id}")
  public String detail(@PathVariable("id") long id) {
    return "todos/detail";
  }
}
