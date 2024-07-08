package com.example.CodeGuardian.repository;

import com.example.CodeGuardian.Entity.task;
import org.springframework.data.repository.CrudRepository;


public interface taskRepo extends CrudRepository<task, Long> {

}
