package com.example.spring_todo_api.controller;

import com.example.spring_todo_api.model.Task;
import com.example.spring_todo_api.service.TaskServiceImpl;
import jakarta.validation.Valid;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    TaskServiceImpl service;

    @Autowired
    TaskController(TaskServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(service.getAllTasks());
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
        Task newTask = service.createTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }
}
