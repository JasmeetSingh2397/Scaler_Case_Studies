package com.example.splitwise_personal.Repositories;

import com.example.splitwise_personal.Models.Expense;
import com.example.splitwise_personal.Models.User;
import com.example.splitwise_personal.Models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserExpenseRepository extends JpaRepository<UserExpense,Long> {
    List<UserExpense> findAllByUser(User user);

}
