package com.example.splitwise_personal.Strategies;

import com.example.splitwise_personal.Models.*;

import java.util.*;

public class GroupSettleUpStrategy{

    class Record{
        User user;
        int pendingAmount;

        public Record(User user, int pendingAmount) {
            this.user = user;
            this.pendingAmount = pendingAmount;
        }
    }

    public List<Transaction> settleUp(List<GroupExpense> groupExpenses) {
        Map<User, Integer> extraMoney= new HashMap<>();
        for(GroupExpense groupExpense:groupExpenses){
            for(UserExpense userExpense: groupExpense.getExpense().getUserExpenses()){
                User user= userExpense.getUser();
                if(!extraMoney.containsKey(user)){
                    extraMoney.put(user, 0);
                }
                if(userExpense.getUserexpenseType().equals(UserExpenseType.paidAmount)){
                    extraMoney.put(user,extraMoney.get(user)+userExpense.getAmount());
                }
                else if(userExpense.getUserexpenseType().equals(UserExpenseType.hadToPay)){
                    extraMoney.put(user,extraMoney.get(user)-userExpense.getAmount());

                }
            }


            }
        Queue<Record> negativeQueue= new PriorityQueue<>();
        Queue<Record> positiveQueue= new PriorityQueue<>();

        for(User user: extraMoney.keySet()){
            if(extraMoney.get(user)>0){
                positiveQueue.add(new Record(user,extraMoney.get(user)));
            }
            else if (extraMoney.get(user)<0){
                negativeQueue.add(new Record(user,extraMoney.get(user)));
            }

        }
        List<Transaction> transactions= new ArrayList<>();

        while(!positiveQueue.isEmpty() && !negativeQueue.isEmpty()){
            Record positive= positiveQueue.remove();
            Record negative= negativeQueue.remove();

            if(positive.pendingAmount>Math.abs(negative.pendingAmount)){
                transactions.add(new Transaction(negative.user.toDto(), positive.user.toDto(), negative.pendingAmount));
                positiveQueue.add(new Record(positive.user, positive.pendingAmount- Math.abs(negative.pendingAmount)));
            }

            else if(positive.pendingAmount<Math.abs(negative.pendingAmount)){
                transactions.add(new Transaction(negative.user.toDto(), positive.user.toDto(), positive.pendingAmount));
                negativeQueue.add(new Record(negative.user, negative.pendingAmount+ Math.abs(positive.pendingAmount)));
            }


        }

        return transactions;
    }
}
