package com.example.splitwise_personal.Repositories;

import com.example.splitwise_personal.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {
    Optional<Group> findbyId(Long GroupId);

}
