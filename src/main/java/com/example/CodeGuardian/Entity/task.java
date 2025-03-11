package com.example.CodeGuardian.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    // Конструктор по умолчанию
    public task() {
    }

    public task(String text, User author) {
        this.text = text;
        this.author = author;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
