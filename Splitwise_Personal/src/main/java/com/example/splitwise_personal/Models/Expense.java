package com.example.splitwise_personal.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Expense extends BaseModel{
    @ManyToOne
    private User createdBy;

    private int amount;
    private String description;

    @OneToMany(mappedBy = "expense")
    private List<UserExpense> userExpenses;




}
