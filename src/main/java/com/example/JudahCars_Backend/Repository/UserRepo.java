package com.example.JudahCars_Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.JudahCars_Backend.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{

}
