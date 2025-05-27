package com.example.JudahCars_Backend.Controller;

import com.example.JudahCars_Backend.DTO.ProductCreateDTO;
import com.example.JudahCars_Backend.DTO.ProductSearchDTO;
import com.example.JudahCars_Backend.DTO.ProductUpdateDTO;
import com.example.JudahCars_Backend.Model.Product;
import com.example.JudahCars_Backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;





    @GetMapping("/products")
    public List<Product> searchProducts(
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) BigDecimal price,
            @RequestParam(required = false) Integer mileage,
            @RequestParam(required = false) String fuelType,
            @RequestParam(required = false) String transmission,
            @RequestParam(required = false) String type
    ) {
        ProductSearchDTO dto = new ProductSearchDTO(toProperCase(make), toProperCase(model), year, price, mileage, toProperCase(fuelType), toProperCase(transmission),type == null ? type : type.toLowerCase());
        return service.searchProducts(dto);
    }
    private static String toProperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }



    @PostMapping("/products")
    public String addProduct(@RequestBody ProductCreateDTO product){
        service.addProduct(product);
        return "added";
    }

    @DeleteMapping("/products/{id}")
    public String removeProduct(@PathVariable int id){
        service.removeProduct(id);
        return "removed";
    }

    @PatchMapping("/products/{id}")
    public String updateProduct(@PathVariable int id,@RequestBody ProductUpdateDTO product){
        service.updateProduct(id,product);
        return "updated";
    }




}
