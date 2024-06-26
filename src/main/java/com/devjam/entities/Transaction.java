package com.devjam.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transaction extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private int user_id;

    private String transaction_Date;

    private long transactionAmount;

    private String updatedAt;

    private String createdAt;

    private int CCId;
}
