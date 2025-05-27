package com.example.JudahCars_Backend.DTO;


import com.example.JudahCars_Backend.Model.Product;
import com.example.JudahCars_Backend.DTO.ProductSearchDTO;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class ProductSpecification {

    public static Specification<Product> getProductsByFilter(ProductSearchDTO searchDTO) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (searchDTO.getMake() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("make"), searchDTO.getMake()));
            }
            if(searchDTO.getType() != null){
                predicate = cb.and(predicate, cb.equal(root.get("type"), searchDTO.getType()));
            }
            if (searchDTO.getModel() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("model"), searchDTO.getModel()));
            }
            if (searchDTO.getYear() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("year"), searchDTO.getYear()));
            }
            if (searchDTO.getPrice() != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("price"), searchDTO.getPrice()));
            }
            if (searchDTO.getMileage() != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("mileage"), searchDTO.getMileage()));
            }
            if (searchDTO.getFuelType() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("fuelType"), searchDTO.getFuelType()));
            }
            if (searchDTO.getTransmission() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("transmission"), searchDTO.getTransmission()));
            }

            return predicate;
        };
    }
}
