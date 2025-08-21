package com.example.TodoSpringApi;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<Todo>();

        todos.add(new Todo(1, false, "Buy groceries", 1));
        todos.add(new Todo(2, true, "Walk the dog", 1));
        todos.add(new Todo(3, false, "Read a book", 2));
    }
}
