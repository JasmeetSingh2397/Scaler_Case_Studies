package com.example.splitwise_personal.Services;

import com.example.splitwise_personal.Exceptions.NoGroupFoundException;
import com.example.splitwise_personal.Models.Expense;
import com.example.splitwise_personal.Models.Group;
import com.example.splitwise_personal.Models.GroupExpense;
import com.example.splitwise_personal.Models.Transaction;
import com.example.splitwise_personal.Repositories.GroupExpenseRepository;
import com.example.splitwise_personal.Repositories.GroupRepository;
import com.example.splitwise_personal.Strategies.GroupSettleUpStrategy;
import com.example.splitwise_personal.Strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    private GroupExpenseRepository groupExpenseRepository;

    private GroupSettleUpStrategy settleUpStrategy;
    @Autowired
    public GroupService(GroupRepository groupRepository, GroupExpenseRepository groupExpenseRepository
            , GroupSettleUpStrategy settleUpStrategy) {
        this.groupRepository = groupRepository;
        this.groupExpenseRepository = groupExpenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUp(Long groupId) throws NoGroupFoundException {
        Optional<Group> OptionalGroup= groupRepository.findbyId(groupId);
        if(OptionalGroup.isEmpty()){
            throw new NoGroupFoundException("Group with the given group id not found");
        }
        Group group= OptionalGroup.get();
        List<GroupExpense> groupExpenses= groupExpenseRepository.findAllByGroup(group);
        List<Expense> expenses= new ArrayList<>();
        for(GroupExpense groupExpense:groupExpenses){
            expenses.add(groupExpense.getExpense());
        }
        return settleUpStrategy.settleUp(groupExpenses);

    }
}
