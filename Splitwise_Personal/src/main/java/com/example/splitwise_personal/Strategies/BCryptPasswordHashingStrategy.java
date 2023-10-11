package com.example.splitwise_personal.Strategies;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordHashingStrategy implements PasswordHashingStrategy{
    BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
    @Override
    public String hash(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
