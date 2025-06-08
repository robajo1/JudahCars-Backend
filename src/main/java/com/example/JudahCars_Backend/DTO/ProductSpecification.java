package com.example.JudahCars_Backend.DTO;

import com.example.JudahCars_Backend.Model.Product;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class ProductSpecification {

    public static Specification<Product> getProductsByFilter(ProductSearchDTO searchDTO) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();
            query.orderBy(cb.asc(root.get("make")));

            if (searchDTO.getMake() != null) {
                predicate = cb.and(predicate, cb.equal(cb.lower(root.get("make")), searchDTO.getMake()));
            }
            if (searchDTO.getType() != null) {
                predicate = cb.and(predicate, cb.equal(cb.lower(root.get("type")), searchDTO.getType()));
            }
            if (searchDTO.getModel() != null) {
                predicate = cb.and(predicate, cb.equal(cb.lower(root.get("model")), searchDTO.getModel()));
            }
            if (searchDTO.getQuery() != null && !searchDTO.getQuery().trim().isEmpty()) {
                String searchTerm = "%" + searchDTO.getQuery().toLowerCase() + "%";

                Predicate makeLikePredicate = cb.like(cb.lower(root.get("make")), searchTerm);

                Predicate modelLikePredicate = cb.like(cb.lower(root.get("model")), searchTerm);
                Predicate combinedLikePredicate = cb.or(makeLikePredicate, modelLikePredicate);
                predicate = cb.and(predicate, combinedLikePredicate);
            }
            if (searchDTO.getYear() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("year"), searchDTO.getYear()));
            }
            if (searchDTO.getMinPrice() != null) {
                query.orderBy(cb.asc(root.get("price")));
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("price"), searchDTO.getMinPrice()));
            }
            if (searchDTO.getMaxPrice() != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("price"), searchDTO.getMaxPrice()));
            }
            if (searchDTO.getMinMileage() != null) {
                query.orderBy(cb.asc(root.get("mileage")));
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("mileage"), searchDTO.getMinMileage()));
            }
            if (searchDTO.getMaxMileage() != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("mileage"), searchDTO.getMaxMileage()));
            }

            if (searchDTO.getFuelType() != null) {
                predicate = cb.and(predicate, cb.equal(cb.lower(root.get("fuelType")), searchDTO.getFuelType()));
            }
            if (searchDTO.getTransmission() != null) {
                predicate = cb.and(predicate,
                        cb.equal(cb.lower(root.get("transmission")), searchDTO.getTransmission()));
            }

            if (searchDTO.getLocation() != null) {
                predicate = cb.and(
                    predicate,
                    cb.like(cb.lower(root.get("location")), "%" + searchDTO.getLocation().toLowerCase() + "%")
                );
            }

            // Add ordering by price and mileage (both ascending)

            return predicate;
        };
    }
}
