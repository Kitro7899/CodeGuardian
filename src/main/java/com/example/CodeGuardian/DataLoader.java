package com.example.CodeGuardian;

import com.example.CodeGuardian.Entity.task;
import com.example.CodeGuardian.repository.taskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private taskRepo taskRepo;

    @Override
    public void run(String... args) throws Exception {
        if (taskRepo.count() == 0) {
            taskRepo.save(new task("Пример задачи"));
        }
    }
}
