package com.example.demo.service.impl;

import com.example.demo.dao.AdminMapper;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员service实现类
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username, password)>0;
    }
}
