package com.example.todolist_api2.controller.user;

import com.example.todolist_api2.dto.user.UserDto;
import com.example.todolist_api2.mappers.user.UserMapper;
import com.example.todolist_api2.service.user.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/user"})
@AllArgsConstructor
@Tag(name = "Usuarios", description = "Operaciones relacionadas con los usuarios")
@SecurityRequirement(name = "Security Token")
public class UserController {
   private UserMapper userMapper;
   private UserService userService;

   @Operation(summary = "Obtener usuario por ID", description = "Devuelve los detalles de un usuario específico")
   @ApiResponse(responseCode = "200", description = "Usuario obtenido exitosamente")
   @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
   @GetMapping({"/{id}"})
   public ResponseEntity<?> getUserById(@Parameter(description = "ID del usuario a obtener") @PathVariable("id") Long id_user) {
      UserDto user = userMapper.UserToUserDto(userService.getUserById(id_user));
      return ResponseEntity.ok().body(user);
   }

}
