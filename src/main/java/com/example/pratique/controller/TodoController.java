package com.example.pratique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

  // 指定されたIDのToDo詳細画面を表示する。
  @GetMapping("/todos/{id}")
  public String detail(@PathVariable("id") long id) {
    return "todos/detail";
  }
}
