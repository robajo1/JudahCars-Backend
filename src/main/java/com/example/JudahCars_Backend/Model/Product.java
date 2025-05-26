package com.example.JudahCars_Backend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
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
    @Column(columnDefinition = "TEXT")
    private String description;
    private String location;

    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;

    private String sketchfabEmbed;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "userId")
    private Users seller;
}
