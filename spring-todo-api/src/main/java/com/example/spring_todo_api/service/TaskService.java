package com.example.spring_todo_api.service;

import com.example.spring_todo_api.model.Task;

import java.util.List;
import java.util.Optional;

interface TaskService{
    List<Task> getAllTasks();
    Optional<Task> getTaskById(long id);
    Task createTask(Task task);
    Task updateTask(long id, Task task);
    String deleteTask(long id);
}
