package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.DTO.SendMessageDTO;
import com.example.JudahCars_Backend.Model.Conversation;
import com.example.JudahCars_Backend.Model.Message;
import com.example.JudahCars_Backend.Model.Users;
import com.example.JudahCars_Backend.Repository.ConversationRepo;
import com.example.JudahCars_Backend.Repository.MessageRepo;
import com.example.JudahCars_Backend.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    MessageRepo msgRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ConversationRepo conRepo;



    public List<Message> getMessages(Integer buyerId, Integer sellerId) {
        return msgRepo.findBySender_UserIdAndReceiver_UserId(buyerId,sellerId);
    }

    public void sendMessage(SendMessageDTO msgDto) {
        Users sender = userRepo.findById(msgDto.getSenderId()).orElseThrow();
        Users reciever = userRepo.findById(msgDto.getRecieverId()).orElseThrow();

        Message msg = new Message();
        msg.setMessageText(msgDto.getMessageText());
        msg.setSentAt(msgDto.getSentAt());
        msg.setReceiver(reciever);
        msg.setSender(sender);
        Optional<Conversation> optionalCon = conRepo.findByBuyerAndSeller(sender, reciever);
        Conversation con = optionalCon.orElseGet(() -> {
            Conversation newCon = new Conversation();
            newCon.setBuyer(sender);
            newCon.setSeller(reciever);
            return conRepo.save(newCon);
        });



        msgRepo.save(msg);
    }

    public List<Conversation> getconversation(Integer sellerid) {
        return conRepo.findAllBySeller_UserId(sellerid);
    }

    public List<Message> getConversationMessaged(Integer conversationid) {
        return msgRepo.findByConversation_Id(conversationid);
    }
}
