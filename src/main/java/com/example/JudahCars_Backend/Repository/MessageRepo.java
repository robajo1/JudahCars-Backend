package com.example.JudahCars_Backend.Repository;

import com.example.JudahCars_Backend.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message,Integer> {


    List<Message> findByConversation_Id(Integer conversationid);




    List<Message> findBySender_UserIdAndReceiver_UserId(Integer buyerId, Integer sellerId);
}
