package com.example.TodoSpringApi;

import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService {
    @Override
    public String doSomething() {
       return "Doing something in FakeTodoService";
    }
}
