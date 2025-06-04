package com.example.JudahCars_Backend.Controller;

import com.example.JudahCars_Backend.Service.PaymentService;
import com.example.JudahCars_Backend.DTO.PaymentRequestDTO;
import com.example.JudahCars_Backend.Exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public String initializePayment(@RequestBody PaymentRequestDTO paymentRequest) {
        String checkoutUrl = paymentService.initializePayment(paymentRequest);
        if (checkoutUrl == null) {
            throw new ResourceNotFoundException("Checkout URL could not be generated");
        }
        return checkoutUrl;
    }
}