package com.example.JudahCars_Backend.DTO;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private Double amount;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
}
