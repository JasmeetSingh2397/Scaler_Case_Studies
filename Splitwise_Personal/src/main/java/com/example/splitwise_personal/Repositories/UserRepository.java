package com.example.splitwise_personal.Repositories;

import com.example.splitwise_personal.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
}
