package com.example.splitwise_personal.Strategies;

import com.example.splitwise_personal.Models.Expense;
import com.example.splitwise_personal.Models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);
}
