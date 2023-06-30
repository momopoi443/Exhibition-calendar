package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.User;


public interface UserService {

    User getUserById(Long userId);

    Double decreaseUserBalanceBy(Long userId, Double subtractAmount);

    User getUserByUserName(String userName);
}
