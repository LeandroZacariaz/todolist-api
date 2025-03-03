package com.example.todolist_api2.service.auth;

import com.example.todolist_api2.dto.auth.AuthResponseDto;
import com.example.todolist_api2.dto.user.UserLoginDto;
import com.example.todolist_api2.dto.user.UserRegisterDto;

public interface AuthService {
   AuthResponseDto login(UserLoginDto userLoginDto);

   AuthResponseDto register(UserRegisterDto userRegisterDto);

   String getCurrentUserEmail();
}
