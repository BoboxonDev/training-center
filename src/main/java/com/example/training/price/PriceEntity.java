package com.example.training.price;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Builder
@Data
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Integer amount;

    public PriceEntity() {

    }


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime daletedAt;
}
