package com.devjam.dto;

import com.devjam.entities.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class TransactionList {
    List<Transaction> transactionList;
}
