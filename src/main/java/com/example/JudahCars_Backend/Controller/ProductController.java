package com.example.JudahCars_Backend.Controller;

import com.example.JudahCars_Backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/product")
    public List<?> getAll() {
        return service.getAllProducts();
    }


}