package com.example.JudahCars_Backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageDTO {
    private String messageText;
    private LocalDateTime sentAt;
    private Integer senderId;
    private Integer recieverId;
}
