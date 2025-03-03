package com.example.todolist_api2.service.todo;

import com.example.todolist_api2.domain.ToDo;
import com.example.todolist_api2.dto.todo.ToDoCreateDto;
import com.example.todolist_api2.dto.todo.ToDoDto;
import org.springframework.data.domain.Page;

public interface ToDoService {
   ToDoDto createToDo(ToDoCreateDto toDoCreateDto);

   Page<ToDoDto> getAllToDos(int page, int limit);

   ToDo getToDoById(Long id_toDo);

   void deleteToDo(Long id_toDo);

   ToDoDto updateToDo(Long id_toDo, ToDoCreateDto toDoCreateDto);
}
