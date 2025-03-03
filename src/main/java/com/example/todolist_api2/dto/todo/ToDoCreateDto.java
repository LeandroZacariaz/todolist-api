package com.example.todolist_api2.dto.todo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO para la creación de una tarea (To-Do)")
public record ToDoCreateDto(
    @NotNull(message = "The to-do title cannot be null.")
    @NotBlank(message = "The to-do title cannot be empty.")
    @Schema(description = "Título de la tarea", example = "Comprar comida")
    String title,
    @NotNull(message = "The to-do description cannot be null.")
    @NotBlank(message = "The to-do description cannot be empty.")
    @Schema(description = "Descripción detallada de la tarea", example = "Comprar pan y leche en el supermercado")
    String description
) {

}
