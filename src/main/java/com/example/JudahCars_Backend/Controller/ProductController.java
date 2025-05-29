package com.example.JudahCars_Backend.Controller;

import com.example.JudahCars_Backend.DTO.ProductCreateDTO;
import com.example.JudahCars_Backend.DTO.ProductSearchDTO;
import com.example.JudahCars_Backend.DTO.ProductUpdateDTO;
import com.example.JudahCars_Backend.Model.Product;
import com.example.JudahCars_Backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
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
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String query
    ) {
        ProductSearchDTO dto = new ProductSearchDTO(toProperCase(make), toProperCase(model),toProperCase(query), year, price, mileage, toProperCase(fuelType), toProperCase(transmission),type == null ? type : type.toLowerCase());
        return service.searchProducts(dto);
    }
    private static String toProperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.toLowerCase();
    }

    @GetMapping("/products/{sellerid}")
    public List<Product> searchSellerProducts(@PathVariable Integer sellerid){
        return service.searchSellerProducts(sellerid);
    }



    @PostMapping("/products")
    public ResponseEntity<Map<String, String>> addProduct(@RequestBody ProductCreateDTO product){
        service.addProduct(product);
         Map<String, String> response = Map.of("message", "Product added successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, String>> removeProduct(@PathVariable int id){
        service.removeProduct(id);
        Map<String, String> response = Map.of("message", "Product removed successfully");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<Map<String, String>> updateProduct(@PathVariable int id,@RequestBody ProductUpdateDTO product){
        service.updateProduct(id,product);
        Map<String, String> response = Map.of("message", "Product updated successfully");
        return ResponseEntity.ok(response);
    }




}
