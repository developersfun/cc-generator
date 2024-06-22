package com.devjam.dto;

import com.devjam.entities.Transaction;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class TransactionList {
    private List<Transaction> transactionList;

    public List<Transaction> getTransactionList(){
        return transactionList;
    }
}
