package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.DTO.UserCreateDTO;
import com.example.JudahCars_Backend.Model.Users;
import com.example.JudahCars_Backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users addUser(UserCreateDTO dto) {
        Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());
        user.setFullName(dto.getFullName());
        user.setPhone(dto.getPhone());

        return userRepo.save(user);
    }
}
