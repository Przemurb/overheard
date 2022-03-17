package com.example.overheard.main.api;

import com.example.overheard.main.user.User;
import com.example.overheard.main.user.UserDao;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void registration(UserRegistrationDto userRegistration) {
        User newUser = UserMapper.map(userRegistration);
        hashPassword(newUser);
        userDao.save(newUser);
    }

    private void hashPassword(User user) {
        String hashPassword = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(hashPassword);
    }

    private static class UserMapper {
        static User map(UserRegistrationDto user) {
            return new User(user.getUsername(), user.getEmail(), user.getPassword(), LocalDateTime.now());
        }
     }
}
