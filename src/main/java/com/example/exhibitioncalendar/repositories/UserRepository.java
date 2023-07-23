package com.example.exhibitioncalendar.repositories;

import com.example.exhibitioncalendar.dataModels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);
}
