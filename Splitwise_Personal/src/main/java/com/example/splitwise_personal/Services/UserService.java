package com.example.splitwise_personal.Services;

import com.example.splitwise_personal.Exceptions.UserNotFoundException;
import com.example.splitwise_personal.Models.Transaction;
import com.example.splitwise_personal.Models.User;
import com.example.splitwise_personal.Models.UserExpense;
import com.example.splitwise_personal.Repositories.UserExpenseRepository;
import com.example.splitwise_personal.Repositories.UserRepository;
import com.example.splitwise_personal.Strategies.PasswordHashingStrategy;

import java.util.List;
import java.util.Optional;

public class UserService {
    private PasswordHashingStrategy passwordHashingStrategy;
    private UserRepository userRepository;

    private UserExpenseRepository userExpenseRepository;
    public User RegisterUser(String name, String phoneNumber, String password){
        User user= new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(passwordHashingStrategy.hash(password));

        User savedUser= userRepository.save(user);
        return savedUser;
    }

    public List<Transaction> settleUp(Long userId) throws UserNotFoundException {
        Optional<User> optionalUser= userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserNotFoundException("User with the given UserId does not exist");
        }
        User user= optionalUser.get();
        List<UserExpense> userExpenses= userExpenseRepository.findAllByUser(user);






    }
}
