package com.example.todolist_api2.service.user;

import com.example.todolist_api2.domain.User;
import com.example.todolist_api2.domain.enums.RoleUserEnum;
import com.example.todolist_api2.dto.user.UserRegisterDto;
import com.example.todolist_api2.exceptions.ResourceNotFoundException;
import com.example.todolist_api2.mappers.user.UserMapper;
import com.example.todolist_api2.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
   private UserMapper userMapper;
   private UserRepository userRepository;
   private PasswordEncoder passwordEncoder;

   public User createUser(UserRegisterDto userRegisterDto) {
      User userCreated = userMapper.UserRegisterDtoToUser(userRegisterDto);
      userCreated.setPassword(passwordEncoder.encode(userRegisterDto.password()));
      userCreated.setRole(RoleUserEnum.USER);
      userRepository.save(userCreated);
      return userCreated;
   }

   public User getLoggingInUser() {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String email = authentication.getName();
      return userRepository.findByEmail(email).orElseThrow(() -> {
         return new UsernameNotFoundException("User not found.");
      });
   }

   public User getUserById(Long id_user) {
      return userRepository.findById(id_user).orElseThrow(() -> {
         return new ResourceNotFoundException("User not found.");
      });
   }

}
