package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
    public User selectUserById(int id);
    public boolean login(User user);
    public boolean zhuCe(User user);
}
