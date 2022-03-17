package com.example.overheard.main.api;

import com.example.overheard.main.user.User;
import com.example.overheard.main.user.UserDao;

import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void registration(UserRegistrationDto userRegistration) {
        User newUser = UserMapper.map(userRegistration);
        userDao.save(newUser);
    }
     private static class UserMapper {
        static User map(UserRegistrationDto user) {
            return new User(user.getUsername(), user.getEmail(), user.getPassword(), LocalDateTime.now());
        }
     }
}
