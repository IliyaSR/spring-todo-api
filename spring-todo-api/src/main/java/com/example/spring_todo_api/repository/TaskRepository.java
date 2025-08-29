package com.example.spring_todo_api.repository;

import com.example.spring_todo_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRepository extends JpaRepository<Task, Long> {
}
