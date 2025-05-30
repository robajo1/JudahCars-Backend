package com.example.JudahCars_Backend.Repository;

import com.example.JudahCars_Backend.Model.Conversation;
import com.example.JudahCars_Backend.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConversationRepo extends JpaRepository<Conversation,Long> {
    List<Conversation> findAllBySeller_UserId(Integer sellerid);

    Optional<Conversation> findByBuyerAndSeller(Users sender, Users reciever);
}
