package com.example.splitwise_personal.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GroupExpense extends BaseModel{

    @ManyToOne
    private Group group;

    @OneToOne
    private Expense expense;


}
