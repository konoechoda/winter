package com.example.demo.dao;


import com.example.demo.domain.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 dao
 */
@Repository
public interface ConsumerMapper {
    /**
     * 增加
     * @param consumer
     * @return
     */
    public int insert(Consumer consumer);

    /**
     * 修改
     * @param consumer
     * @return
     */
    public int update(Consumer consumer);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);

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
     * 根据用户名模糊查询
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
    public int verifyPassword(String username,String password);
}
