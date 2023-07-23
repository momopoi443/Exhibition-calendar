package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.dataModels.entities.User;
import com.example.exhibitioncalendar.repositories.UserRepository;
import com.example.exhibitioncalendar.services.exceptions.NotEnoughMoneyException;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> {
                    var ex = new NotFoundException("No user with such id");
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
    }

    @Override
    public Double decreaseUserBalanceBy(Long userId, Double subtractAmount) {
        User user = getUserById(userId);

        if (user.getBalance() < subtractAmount) {
            var ex = new NotEnoughMoneyException("Not enough money to buy ticket");
            log.error(ex.getLocalizedMessage());
            throw ex;
        }
        user.setBalance(user.getBalance() - subtractAmount);

        User savedUser = userRepository.save(user);

        log.info("Decreased balance of User with id " + savedUser.getId() + " by " + subtractAmount);

        return savedUser.getBalance();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository
                .findUserByUserName(userName)
                .orElseThrow(() -> {
                    var ex = new NotFoundException("No user with such username");
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
    }
}
