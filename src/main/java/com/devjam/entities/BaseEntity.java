package com.devjam.entities;

import java.time.ZonedDateTime;

public class BaseEntity {

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private byte isDeleted = 0;

}
