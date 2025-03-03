package com.example.todolist_api2.exceptions;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
       super(message);
    }
 }
 