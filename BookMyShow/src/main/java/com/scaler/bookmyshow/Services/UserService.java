package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Exceptions.NoUserFoundException;
import com.scaler.bookmyshow.Repositories.UserRepository;
import com.scaler.bookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) throws NoUserFoundException {
        Optional<User> optionalUser= userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new NoUserFoundException("User not found");
        }
        User user= optionalUser.get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(bCryptPasswordEncoder.matches(password,user.getPassword())){
            return user;
        }
        throw new RuntimeException("Invalid Password");


    }
    public User signup(String email, String password){
        Optional<User> optionalUser= userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            throw new RuntimeException("User with email already exists");
        }
        User user=new User();
        user.setEmail(email);

        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        user.setUsername("");
        user.setBookings(new ArrayList<>());
        User savedUser= userRepository.save(user);
        return savedUser;
    }
}
