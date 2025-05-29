package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.DTO.LoginRequest;
import com.example.JudahCars_Backend.DTO.UserCreateDTO;
import com.example.JudahCars_Backend.JWT.JwtUtils;
import com.example.JudahCars_Backend.Model.UserPrincipal;
import com.example.JudahCars_Backend.Model.Users;
import com.example.JudahCars_Backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    public Users addUser(UserCreateDTO dto) {
        Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());
        user.setFullName(dto.getFullName());
        user.setPhone(dto.getPhone());

        return userRepo.save(user);
    }


    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            Users user = userPrincipal.getUser();
            user.setPassword(null);

            String token = jwtUtils.generateToken(user.getEmail());


            return ResponseEntity.ok()
                    .header("Authorization", "Bearer " + token)
                    .body(user);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
