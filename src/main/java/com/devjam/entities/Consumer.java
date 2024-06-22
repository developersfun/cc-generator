package com.devjam.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consumer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private String createdAt;

    private String updatedAt;

    private String emaiId;

    private String mobileNumber;



}
