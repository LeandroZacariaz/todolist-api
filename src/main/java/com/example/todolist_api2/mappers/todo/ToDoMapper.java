package com.example.todolist_api2.mappers.todo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.todolist_api2.domain.ToDo;
import com.example.todolist_api2.dto.todo.ToDoCreateDto;
import com.example.todolist_api2.dto.todo.ToDoDto;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    @Mapping(target = "id_todo", ignore = true)
    @Mapping(target = "user", ignore = true)
    ToDo toDoCreateDtoToToDo(ToDoCreateDto toDoCreateDto);
    ToDoDto toDoToToDoDto(ToDo toDo);
}
