package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 管理员Dao
 */
@Repository
@Mapper
public interface AdminMapper {
    /**
     * 验证密码
     * @param username
     * @param password
     * @return
     */
    public int verifyPassword(String username,String password);
}
