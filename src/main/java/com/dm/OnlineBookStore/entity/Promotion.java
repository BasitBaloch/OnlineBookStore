package com.dm.OnlineBookStore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String promotionCode;
    private String bookType;
    private int discount;

}
