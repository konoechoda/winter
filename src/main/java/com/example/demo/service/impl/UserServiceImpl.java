package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public User selectUserById(int id){
        return userMapper.selectUserById(id);
    }

    public boolean login(User user){
        String name = user.getName();
        String password = user.getPassword();
        User u1 =  userMapper.selectUserByName(name);
        if(u1==null){
            return false;
        }else{
            if(u1.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean zhuCe(User user){
        int x = userMapper.insertUser(user);
        if(x>0){
            return true;
        }else {
            return false;
        }
    }
}
