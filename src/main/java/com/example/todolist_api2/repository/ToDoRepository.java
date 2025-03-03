package com.example.todolist_api2.repository;

import com.example.todolist_api2.domain.ToDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
   Page<ToDo> findByUser_Email(String email, Pageable pageable);
}
