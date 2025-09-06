package com.example.spring_todo_api.service;

import com.example.spring_todo_api.model.Task;

import java.util.List;

interface TaskService{
    List<Task> getAllTasks();
    Task createTask(Task task);
    Task updateTask(Task task);
}
