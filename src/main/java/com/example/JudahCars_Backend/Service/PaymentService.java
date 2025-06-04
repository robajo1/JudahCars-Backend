package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.DTO.PaymentRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${chapa.secret-key}")
    private String chapaSecretKey;

    private final String CHAPA_API_URL = "https://api.chapa.co/v1/transaction/initialize";

    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String initializePayment(PaymentRequestDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + chapaSecretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("amount", dto.getAmount());
        body.put("currency", "ETB");
        body.put("email", dto.getEmail());
        body.put("first_name", dto.getFirstName());
        body.put("last_name", dto.getLastName());
        body.put("description", dto.getDescription());
        // body.put("callback_url", "https://yourdomain.com/api/payment/callback"); //
        // Optional
        body.put("return_url", "http://localhost:5173"); // Optional

        Map<String, Object> customization = new HashMap<>();
        customization.put("description", dto.getDescription());
        body.put("customization", customization);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        System.out.println(request);
        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(CHAPA_API_URL, request, Map.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                Map<String, Object> data = (Map<String, Object>) response.getBody().get("data");
                String checkoutUrl = (String) data.get("checkout_url");
                return checkoutUrl;
            } else {
                System.err.println("Chapa API returned error: " + response.getStatusCode());
            }
        } catch (Exception e) {
            System.err.println("Error initializing Chapa payment:");
            e.printStackTrace();
        }

        return null;
    }
}
