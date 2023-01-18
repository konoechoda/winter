package com.example.demo.service;

import com.example.demo.domain.Consumer;

import java.util.List;

/**
 * 用户Service接口
 */
public interface ConsumerService {
    /**
     * 增加
     * @param consumer
     * @return
     */
    public boolean insert(Consumer consumer);

    /**
     * 修改
     * @param consumer
     * @return
     */
    public boolean update(Consumer consumer);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 查询
     * @param id
     * @return
     */
    public Consumer selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<Consumer> allConsumer();

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public List<Consumer> getByUsername(String username);

    /**
     * 验证密码
     * @param username
     * @param password
     * @return
     */
    public boolean verifyPassword(String username,String password);
}
