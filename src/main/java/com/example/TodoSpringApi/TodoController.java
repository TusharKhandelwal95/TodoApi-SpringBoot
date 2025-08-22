package com.example.TodoSpringApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todoList;

//    @Autowired -- but this is generally not allowed as good practice as it creates tight coupling
    // alse we cannot make the fields final
    private TodoService todoService;
    private TodoService todoService2;

    public TodoController(
            @Qualifier("fakeTodoService") TodoService todoService,
            @Qualifier("anotherTodoService") TodoService todoService2
    ) {
        this.todoService = todoService;
        this.todoService2 = todoService2;
        todoList = new ArrayList<Todo>();

        todoList.add(new Todo(1, false, "Buy groceries", 1));
        todoList.add(new Todo(2, true, "Walk the dog", 1));
        todoList.add(new Todo(3, false, "Read a book", 2));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false) String completed) {

        System.out.println("Incoming query param: " + completed + " " + this.todoService.doSomething());

        return ResponseEntity.ok(todoList);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)  --> this could be used
    public ResponseEntity<Todo> addTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable int id) {  // Using wildcard type for response entity
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                return ResponseEntity.ok(todo);
            }
        }
//        return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Todo with id " + id + " not found.");

    }
}
