package com.example.demo.service;

/**
 * 管理员service接口
 */
public interface AdminService {

    //验证密码
    public boolean verifyPassword(String username,String password);
}
