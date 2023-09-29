package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOs.*;
import com.scaler.bookmyshow.Exceptions.NoUserFoundException;
import com.scaler.bookmyshow.Repositories.UserRepository;
import com.scaler.bookmyshow.Services.UserService;
import com.scaler.bookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    public UserSignupResponseDTO signup(UserSignupRequestDTO userSignupRequestDTO){
        UserSignupResponseDTO userSignupResponseDTO= new UserSignupResponseDTO();
        try{
            User user= userService.signup(userSignupRequestDTO.getEmail(),userSignupRequestDTO.getPassword());
            userSignupResponseDTO.setUserId(user.getId());
            userSignupResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            userSignupResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return userSignupResponseDTO;


    }

    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO){
//        Optional<User> optionalUser = userRepository.findByEmail(userSignupRequestDTO.getEmail());
        UserLoginResponseDTO userLoginResponseDTO= new UserLoginResponseDTO();
        try{
            User user= userService.login(userLoginRequestDTO.getEmail(),userLoginRequestDTO.getPassword());
            userLoginResponseDTO.setUserId(user.getId());
            userLoginResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (RuntimeException | NoUserFoundException e) {
            System.out.println(e.getMessage());
            userLoginResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return userLoginResponseDTO;


    }
}
