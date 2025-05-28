package com.example.JudahCars_Backend.Controller;

import com.example.JudahCars_Backend.DTO.LoginRequest;
import com.example.JudahCars_Backend.DTO.UserCreateDTO;
import com.example.JudahCars_Backend.Model.Users;
import com.example.JudahCars_Backend.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.JudahCars_Backend.Model.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UsersService usersService;


    @PostMapping("/register")
    public ResponseEntity<?> newUser(@RequestBody UserCreateDTO user){
        Users newUser = usersService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return usersService.loginUser(loginRequest);

    }


}
