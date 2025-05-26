package com.example.JudahCars_Backend.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String type;
    private String make;
    private String model;
    private Integer year;
    private BigDecimal price;
    private Integer mileage;
    private String fuelType;
    private String transmission;
    private String description;
    private String location;

    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;

    private String sketchfabEmbed;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "userId")
    private Users seller;

    public Product() {
    }

    public Product(Integer productId, String type, String make, String model, Integer year, BigDecimal price, Integer mileage, String fuelType, String transmission, String description, String location, String imageUrl1, String imageUrl2, String imageUrl3, String sketchfabEmbed, Users seller) {
        this.productId = productId;
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.description = description;
        this.location = location;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.imageUrl3 = imageUrl3;
        this.sketchfabEmbed = sketchfabEmbed;
        this.seller = seller;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getImageUrl3() {
        return imageUrl3;
    }

    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public String getSketchfabEmbed() {
        return sketchfabEmbed;
    }

    public void setSketchfabEmbed(String sketchfabEmbed) {
        this.sketchfabEmbed = sketchfabEmbed;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }
}
