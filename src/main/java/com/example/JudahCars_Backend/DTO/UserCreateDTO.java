package com.example.JudahCars_Backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {


    private Integer userId;

    private String fullName;
    private String email;

    private String password;
    private String role;
    private String phone;
}
