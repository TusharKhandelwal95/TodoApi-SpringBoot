package com.example.TodoSpringApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todoList;

    public TodoController() {
        todoList = new ArrayList<Todo>();

        todoList.add(new Todo(1, false, "Buy groceries", 1));
        todoList.add(new Todo(2, true, "Walk the dog", 1));
        todoList.add(new Todo(3, false, "Read a book", 2));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todoList);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)  --> this could be used
    public ResponseEntity<Todo> addTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        for(Todo todo: todoList){
            if(todo.getId() == id){
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.notFound().build();

    }
}
