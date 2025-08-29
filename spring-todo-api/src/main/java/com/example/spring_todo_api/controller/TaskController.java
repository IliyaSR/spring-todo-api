package com.example.spring_todo_api.controller;

import com.example.spring_todo_api.model.Task;
import com.example.spring_todo_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    TaskService service;

    @Autowired
    TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        List<Task> list = service.getAllTasks();

        return list;
    }
}
