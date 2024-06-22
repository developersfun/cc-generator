package com.devjam.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Card extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String cardToken;

    private String billedDate;

    private String updatedAt;

    private String createdAt;

}
