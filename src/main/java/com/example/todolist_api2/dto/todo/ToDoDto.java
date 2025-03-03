package com.example.todolist_api2.dto.todo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representación de una tarea (To-Do)")
public record ToDoDto(
    @Schema(description = "ID único de la tarea", example = "1")
    Long id_todo,

    @Schema(description = "Título de la tarea", example = "Leer un libro")
    String title,

    @Schema(description = "Descripción de la tarea", example = "Leer 50 páginas del libro de programación")
    String description
) {

}
