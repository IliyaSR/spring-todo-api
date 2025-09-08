package com.example.spring_todo_api.service;

import com.example.spring_todo_api.model.Task;
import com.example.spring_todo_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    @Autowired
    TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Optional<Task> getTaskById(long id) {
        return repo.findById(id);
    }

    public Task createTask(Task task) {
        repo.save(task);
        return task;
    }

    public Task updateTask(long id, Task task) {
        Task currentTask = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        currentTask.setTitle(task.getTitle());
        currentTask.setDescription(task.getDescription());
        currentTask.setCompleted(task.getCompleted());
        return repo.save(currentTask);
    }

    public String deleteTask(long id) {
        repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        repo.deleteById(id);
        return "Task was deleted!";
    }
}
