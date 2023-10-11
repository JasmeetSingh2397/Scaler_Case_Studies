package com.example.splitwise_personal.Models;

import com.example.splitwise_personal.DTOs.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "users")
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String Password;

    public UserDto toDto(){
        UserDto userDto= new UserDto();
        userDto.setName(name);
        userDto.setPhoneNumber(phoneNumber);
        return userDto;
    }
}
