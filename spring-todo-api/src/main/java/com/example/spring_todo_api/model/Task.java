package com.example.spring_todo_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "tasks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title is required!")
    @Size(min = 2, max = 50, message = "Title must be between 2 and 50 letters!")
    @Column(nullable = false)
    private String title;

    private String description;

    @NotNull(message = "Completed field is required!")
    @Column(nullable = false)
    private boolean completed = false;

    @NotNull(message = "CreatedAt is required!")
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
