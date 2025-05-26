package com.example.JudahCars_Backend.Model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    private String messageText;
    private LocalDateTime sentAt;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "userId")
    private Users sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "userId")
    private Users receiver;

    public Message(Integer messageId, String messageText, LocalDateTime sentAt, Users sender, Users receiver) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.sentAt = sentAt;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message() {
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    public Users getReceiver() {
        return receiver;
    }

    public void setReceiver(Users receiver) {
        this.receiver = receiver;
    }
}

