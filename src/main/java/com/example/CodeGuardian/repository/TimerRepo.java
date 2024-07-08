package com.example.CodeGuardian.repository;

import com.example.CodeGuardian.Entity.Timer;
import com.example.CodeGuardian.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimerRepo extends JpaRepository<Timer, Long> {
    Optional<Timer> findByUser(User user);
    void deleteByUser(User user);
}
