package com.example.JudahCars_Backend.Controller;

import com.example.JudahCars_Backend.DTO.SendMessageDTO;
import com.example.JudahCars_Backend.Model.Conversation;
import com.example.JudahCars_Backend.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    MessageService msgService;

    @GetMapping("/messages")
    public List<SendMessageDTO> getMessages(@RequestParam Integer senderId , @RequestParam Integer receiverId){
        return msgService.getMessages(senderId,receiverId);
    }

    @GetMapping("/messages/{conversationid}")
    public List<SendMessageDTO> getMessages(@PathVariable Integer conversationid){
        return msgService.getConversationMessages(conversationid);
    }

    @PostMapping("/messages")
    public String sendMessage(@RequestBody SendMessageDTO msgDto){
        msgService.sendMessage(msgDto);
        return "sent";
    }

    @GetMapping("/conversations/{sellerid}")
    public List<Conversation> getConversation(@PathVariable Integer sellerid){
        return msgService.getconversation(sellerid);
    }
}
