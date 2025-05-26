package com.example.JudahCars_Backend.Repository;

import com.example.JudahCars_Backend.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

   
    List<?> findByTypeContainingIgnoreCaseAndMakeContainingIgnoreCase(String type, String make);

    List<?> findByTypeContainingIgnoreCase(String type);

    List<?> findByMakeContainingIgnoreCase(String make);
}
