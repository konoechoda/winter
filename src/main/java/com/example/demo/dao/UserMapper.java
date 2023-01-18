package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User selectUserById(int id);
    public User selectUserByName(String name);
    public int insertUser(User user);
}