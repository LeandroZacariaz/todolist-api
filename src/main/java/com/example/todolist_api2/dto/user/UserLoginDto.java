package com.example.todolist_api2.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Estructura para la autenticación de usuarios")
public record UserLoginDto(
    @NotNull(message = "The user email cannot be null.")
    @NotBlank(message = "The user email cannot be empty.")
    @Schema(description = "Correo electrónico del usuario", example = "juan.perez@email.com")
    String email,
    @NotNull(message = "The user password cannot be null.")
    @NotBlank(message = "The user password cannot be empty.")
    @Schema(description = "Contraseña del usuario", example = "password123")
    String password
) {

}
