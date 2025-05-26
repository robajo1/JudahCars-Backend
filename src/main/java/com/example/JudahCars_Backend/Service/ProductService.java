package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public List<?> getAllProducts() {
        return repo.findAll();
    }
}
