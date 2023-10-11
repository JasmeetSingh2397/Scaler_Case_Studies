package com.example.splitwise_personal.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Groups")
public class Group extends BaseModel{
    @ManyToMany
    private List<User> members;
    private String name;
    @ManyToOne
    private User createdBy;

    @OneToMany(mappedBy = "group")
    private List<GroupExpense> groupExpenses;

}
