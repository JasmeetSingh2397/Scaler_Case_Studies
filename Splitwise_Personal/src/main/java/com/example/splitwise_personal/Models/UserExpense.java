package com.example.splitwise_personal.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userexpenseType;

}
