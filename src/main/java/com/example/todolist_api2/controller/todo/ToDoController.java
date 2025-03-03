package com.example.todolist_api2.controller.todo;


import com.example.todolist_api2.dto.todo.ToDoCreateDto;
import com.example.todolist_api2.dto.todo.ToDoDto;
import com.example.todolist_api2.mappers.todo.ToDoMapper;
import com.example.todolist_api2.service.todo.ToDoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/todo"})
@AllArgsConstructor
@Tag(name = "Tareas", description = "Operaciones relacionadas con la gestión de tareas")
@SecurityRequirement(name = "Security Token")
public class ToDoController {
   private ToDoService toDoService;
   private ToDoMapper toDoMapper;

   @Operation(summary = "Crear una nueva tarea", description = "Permite agregar una tarea a la lista de pendientes")
   @ApiResponse(responseCode = "201", description = "Tarea creada exitosamente")
   @PostMapping
   public ResponseEntity<?> createToDo(@RequestBody @Valid ToDoCreateDto toDoCreateDto) {
      ToDoDto toDoDto = toDoService.createToDo(toDoCreateDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(toDoDto);
   }

   @Operation(summary = "Actualizar una tarea", description = "Modifica los detalles de una tarea específica")
   @ApiResponse(responseCode = "200", description = "Tarea actualizada exitosamente")
   @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
   @PutMapping({"/{id}"})
   public ResponseEntity<?> updateToDo(@Parameter(description = "ID de la tarea a actualizar") @PathVariable("id") Long id_toDo, @RequestBody @Valid ToDoCreateDto toDoCreateDto) {
      ToDoDto toDoUpdated = toDoService.updateToDo(id_toDo, toDoCreateDto);
      return ResponseEntity.ok().body(toDoUpdated);
   }

   @Operation(summary = "Obtener todas las tareas", description = "Devuelve una lista paginada de todas las tareas")
   @ApiResponse(responseCode = "200", description = "Lista de tareas obtenida exitosamente")
   @GetMapping
   public ResponseEntity<?> getAllToDos(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
      Page<ToDoDto> toDosPage = toDoService.getAllToDos(page, limit);
      return ResponseEntity.ok().body(Map.of("data", toDosPage.getContent(), "page", page, "limit", limit, "total", toDosPage.getTotalElements()));
   }

   @Operation(summary = "Obtener una tarea por ID", description = "Devuelve los detalles de una tarea específica")
   @ApiResponse(responseCode = "200", description = "Tarea obtenida exitosamente")
   @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
   @GetMapping({"/{id}"})
   public ResponseEntity<?> getToDoById(@Parameter(description = "ID de la tarea a obtener") @PathVariable("id") Long id_toDo) {
      ToDoDto toDoDto = toDoMapper.toDoToToDoDto(toDoService.getToDoById(id_toDo));
      return ResponseEntity.ok().body(toDoDto);
   }

   @Operation(summary = "Eliminar una tarea", description = "Elimina una tarea específica por su ID")
   @ApiResponse(responseCode = "204", description = "Tarea eliminada exitosamente")
   @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
   @DeleteMapping({"/{id}"})
   public ResponseEntity<?> deleteToDo(@Parameter(description = "ID de la tarea a eliminar") @PathVariable("id") Long id_toDo) {
      toDoService.deleteToDo(id_toDo);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

}