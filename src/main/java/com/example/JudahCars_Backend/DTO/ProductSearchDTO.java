package com.example.JudahCars_Backend.DTO;

import java.math.BigDecimal;

public class ProductSearchDTO {
    private String make;
    private String model;
    private String query;
    private Integer year;
    private String fuelType;
    private String transmission;
    private String type;
    private String location;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer minMileage;
    private Integer maxMileage;

    public ProductSearchDTO(String make, String model, String query, Integer year,
            String fuelType, String transmission, String type, String location,
            BigDecimal minPrice, BigDecimal maxPrice, Integer minMileage, Integer maxMileage) {
        this.make = make;
        this.type = type;
        this.model = model;
        this.query = query;
        this.year = year;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.location = location;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minMileage = minMileage;
        this.maxMileage = maxMileage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinMileage() {
        return minMileage;
    }

    public void setMinMileage(Integer minMileage) {
        this.minMileage = minMileage;
    }

    public Integer getMaxMileage() {
        return maxMileage;
    }

    public void setMaxMileage(Integer maxMileage) {
        this.maxMileage = maxMileage;
    }
}
