package com.example.todolist_api2.dto.todo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Detalles de una tarea específica")
public record ToDoDetailDto(
    @Schema(description = "ID único de la tarea", example = "1")
    Long id_todo,

    @Schema(description = "Título de la tarea", example = "Hacer ejercicio")
    String title,

    @Schema(description = "Descripción de la tarea", example = "Correr 30 minutos en el parque")
    String description
) {

}
