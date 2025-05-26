package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public static String toProperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    @Autowired
    private ProductRepo repo;


    public List<?> getAllProducts(String type, String make) {
        if (type != null && make != null) {
            return repo.findByTypeContainingIgnoreCaseAndMakeContainingIgnoreCase(type, make);
        } else if (type != null) {
            return repo.findByTypeContainingIgnoreCase(type);
        } else if (make != null) {
            return repo.findByMakeContainingIgnoreCase(make);
        } else {
            return repo.findAll();
        }
    }

}
