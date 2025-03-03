package com.example.todolist_api2.service.user;

import com.example.todolist_api2.domain.User;
import com.example.todolist_api2.dto.user.UserRegisterDto;

public interface UserService {
   User createUser(UserRegisterDto userRegisterDto);

   User getLoggingInUser();

   User getUserById(Long id_user);
}
