package com.devjam.service;

import com.devjam.dto.TransactionList;
import com.devjam.entities.Transaction;

import java.util.List;

public interface StatementGenerator {
    void generateStatement(TransactionList transactionList);
}
