package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long userId);

    Double decreaseUserBalanceBy(Long userId, Double subtractAmount);

    Optional<User> getUserByUserName(String userName);
}
