package com.example.CodeGuardian.repository;

import com.example.CodeGuardian.Entity.task;
import com.example.CodeGuardian.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface taskRepo extends CrudRepository<task, Long> {
    List<task> findByAuthor(User author);
}
