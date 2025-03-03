package com.example.todolist_api2.mappers.user;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.todolist_api2.domain.ToDo;
import com.example.todolist_api2.domain.User;
import com.example.todolist_api2.dto.todo.ToDoDetailDto;
import com.example.todolist_api2.dto.user.UserDto;
import com.example.todolist_api2.dto.user.UserRegisterDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id_user", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "todos", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User UserRegisterDtoToUser(UserRegisterDto userRegisterDto);

    @Mapping(target = "toDos", expression = "java(toDosToToDoDetailDtos(user.getTodos()))")
    UserDto UserToUserDto(User user);

    default List<ToDoDetailDto> toDosToToDoDetailDtos(List<ToDo> toDos) {
        return toDos == null ? null : toDos.stream()
                .map(toDo -> new ToDoDetailDto(toDo.getId_todo(), toDo.getTitle(), toDo.getDescription()))
                .collect(Collectors.toList());
    }
}
