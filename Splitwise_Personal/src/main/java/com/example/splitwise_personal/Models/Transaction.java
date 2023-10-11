package com.example.splitwise_personal.Models;

import com.example.splitwise_personal.DTOs.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Transactions")
@Setter
@Getter
@Entity
public class Transaction extends BaseModel {
    private UserDto to;
    private UserDto from;
    private int amount;

    public Transaction(UserDto to, UserDto from, int amount) {
        this.to = to;
        this.from = from;
        this.amount = amount;
    }


    public Transaction() {

    }
}
