package com.example.JudahCars_Backend.Controller;

import com.example.JudahCars_Backend.DTO.LoginRequest;
import com.example.JudahCars_Backend.DTO.UserCreateDTO;
import com.example.JudahCars_Backend.JWT.JwtUtils;
import com.example.JudahCars_Backend.Model.Users;
import com.example.JudahCars_Backend.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UsersService usersService;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> newUser(@RequestBody UserCreateDTO user){
        Users newUser = usersService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/token")
    public String token(@RequestBody UserCreateDTO user){
        String token = jwtUtils.generateToken(user.getEmail());
        return token;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return usersService.loginUser(loginRequest);
    }
}
