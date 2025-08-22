package com.example.TodoSpringApi;

import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService {

    @TimeMonitor

    @Override
    public String doSomething() {
        for (int i = 0; i < 1000000; i++) {}  // to take some time
       return "Doing something in FakeTodoService";
    }
}
