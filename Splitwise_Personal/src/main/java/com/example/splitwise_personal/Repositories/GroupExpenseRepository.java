package com.example.splitwise_personal.Repositories;

import com.example.splitwise_personal.Models.Group;
import com.example.splitwise_personal.Models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupExpenseRepository extends JpaRepository<GroupExpense,Long> {
    List<GroupExpense> findAllByGroup(Group group);
}
