package com.example.todolist_api2.service.auth;

import com.example.todolist_api2.domain.User;
import com.example.todolist_api2.dto.auth.AuthResponseDto;
import com.example.todolist_api2.dto.user.UserLoginDto;
import com.example.todolist_api2.dto.user.UserRegisterDto;
import com.example.todolist_api2.exceptions.EmailAlreadyExistsException;
import com.example.todolist_api2.exceptions.InvalidCredentialsException;
import com.example.todolist_api2.exceptions.ResourceNotFoundException;
import com.example.todolist_api2.repository.UserRepository;
import com.example.todolist_api2.service.jwt.JwtService;
import com.example.todolist_api2.service.user.UserService;

import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
   private UserService userService;
   private UserRepository userRepository;
   private JwtService jwtService;
   private AuthenticationManager authenticationManager;

   public AuthResponseDto login(UserLoginDto userLoginDto) {
      try {
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDto.email(), userLoginDto.password()));
      } catch (BadCredentialsException var4) {
         throw new InvalidCredentialsException("Invalid email or password.");
      }

      UserDetails user = userRepository.findByEmail(userLoginDto.email()).orElseThrow(() -> {
         return new ResourceNotFoundException("User not found with email: " + userLoginDto.email());
      });
      String token = jwtService.getToken(user);
      return AuthResponseDto.builder().token(token).build();
   }

   public AuthResponseDto register(UserRegisterDto userRegisterDto) {
      if (userRepository.existsByEmail(userRegisterDto.email())) {
         throw new EmailAlreadyExistsException("The email " + userRegisterDto.email() + " is already registered.");
      } else {
         User user = userService.createUser(userRegisterDto);
         return AuthResponseDto.builder().token(jwtService.getToken(user)).build();
      }
   }

   public String getCurrentUserEmail() {
      return SecurityContextHolder.getContext().getAuthentication().getName();
   }

   
}