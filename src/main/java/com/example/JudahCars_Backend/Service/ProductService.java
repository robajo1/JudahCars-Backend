package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

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
