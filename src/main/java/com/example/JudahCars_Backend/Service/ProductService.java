package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.DTO.ProductSearchDTO;
import com.example.JudahCars_Backend.DTO.ProductSpecification;
import com.example.JudahCars_Backend.Model.Product;
import com.example.JudahCars_Backend.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;


    public List<Product> searchProducts(ProductSearchDTO searchDTO) {
        Specification<Product> spec = ProductSpecification.getProductsByFilter(searchDTO);
        return repo.findAll(spec);
    }
}
