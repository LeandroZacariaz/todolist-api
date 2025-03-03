package com.example.todolist_api2.dto.user;

import java.util.List;

import com.example.todolist_api2.domain.enums.RoleUserEnum;
import com.example.todolist_api2.dto.todo.ToDoDetailDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información de un usuario en el sistema")
public record UserDto(
    @Schema(description = "ID único del usuario", example = "10")
    Long id_user,

    @Schema(description = "Nombre del usuario", example = "Juan Pérez")
    String name,

    @Schema(description = "Correo electrónico del usuario", example = "juan.perez@email.com")
    String email,

    @Schema(description = "Rol del usuario en el sistema", example = "USER")
    RoleUserEnum role,

    @Schema(description = "Lista de tareas asociadas al usuario")
    List<ToDoDetailDto> toDos
) {

}
