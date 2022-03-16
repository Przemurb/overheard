package com.example.overheard.main.user;

import java.time.LocalTime;

public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private LocalTime registrationDate;

    public User(String username, String email, String password, LocalTime registrationDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalTime getRegistrationDate() {
        return registrationDate;
    }
}
