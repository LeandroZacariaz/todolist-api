package com.example.todolist_api2.dto.errors;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO estándar para respuestas de error")
public record ErrorDtoResponse(
    @Schema(description = "Tipo de error")
    String error,
    
    @Schema(description = "Mensaje detallado del error")
    String message
) {

}
