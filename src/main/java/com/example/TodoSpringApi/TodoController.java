package com.example.TodoSpringApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todoList;

    public TodoController() {
        todoList = new ArrayList<Todo>();

        todoList.add(new Todo(1, false, "Buy groceries", 1));
        todoList.add(new Todo(2, true, "Walk the dog", 1));
        todoList.add(new Todo(3, false, "Read a book", 2));
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoList;
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return newTodo;
    }
}
