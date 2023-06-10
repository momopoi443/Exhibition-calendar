package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.User;
import com.example.exhibitioncalendar.repositories.UserRepository;
import com.example.exhibitioncalendar.services.exceptions.NotEnoughMoneyException;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Double decreaseUserBalanceBy(Long userId, Double subtractAmount) {
        User user = getUserById(userId)
                .orElseThrow(() -> new NotFoundException("No user with such id"));

        if (user.getBalance() < subtractAmount) {
            throw new NotEnoughMoneyException("Not enough money to buy ticket");
        }
        user.setBalance(user.getBalance() - subtractAmount);

        User savedUser = userRepository.save(user);

        return savedUser.getBalance();
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }
}
