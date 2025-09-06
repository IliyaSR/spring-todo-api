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

    public Task createTask(Task task) {
        repo.save(task);
        return task;
    }

    public Task updateTask(Task task) {
        return repo.save(task);
    }

    public String deleteTask(long id) {
        Optional<Task> task = repo.findById(id);

        if(task.isPresent()){
            repo.deleteById(id);
            return "Deleted!";
        }else{
            return "Don't found element!";
        }
    }
}
