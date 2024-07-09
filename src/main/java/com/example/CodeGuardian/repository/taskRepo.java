package com.example.CodeGuardian.repository;

import com.example.CodeGuardian.Entity.task;
import com.example.CodeGuardian.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface taskRepo extends JpaRepository<task, Long> {
    List<task> findByAuthor(User author);
}
