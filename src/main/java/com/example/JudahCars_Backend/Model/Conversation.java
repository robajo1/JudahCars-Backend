package com.example.JudahCars_Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "conversations",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"buyer_id", "seller_id"})
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "userId", nullable = false)
    private Users buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "userId", nullable = false)
    private Users seller;
}


