package com.devjam.repo;


import com.devjam.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.ZonedDateTime;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, String> {

    @Query("  SELECT \n" +
            "                CCId,\n" +
            "                user_id,\n" +
            "                transactionAmount,\n" +
            "                transaction_Date,\n" +
            "                createdAt,\n" +
            "                updatedAt\n" +
            "            FROM \n" +
            "                Transaction\n" +
            "            WHERE \n" +
            "                user_id = ?\n" +
            "            ORDER BY \n" +
            "                transaction_Date DESC\n" +
            "            ")
    List<Transaction> getAllTransactionRecords(
            String userId);
}
