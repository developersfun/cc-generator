package com.devjam.service;

import com.devjam.entities.Transaction;

import java.util.List;

public interface StatementGenerator {
    void generateStatement(List<Transaction> transactionList);
}
