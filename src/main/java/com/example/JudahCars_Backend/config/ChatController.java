package com.example.JudahCars_Backend.config;

import com.example.JudahCars_Backend.DTO.SendMessageDTO;
import com.example.JudahCars_Backend.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    //we send message to this controller
    @MessageMapping("/chat.sendMessage") // /app/chat.sendMessage
    public void sendMessage(SendMessageDTO messageDTO) {
        messageService.sendMessage(messageDTO);


        messagingTemplate.convertAndSend("/topic/messages/" + messageDTO.getRecieverId(), messageDTO);
    }
}
