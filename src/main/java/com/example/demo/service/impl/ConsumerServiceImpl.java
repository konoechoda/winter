package com.example.demo.service.impl;

import com.example.demo.dao.ConsumerMapper;
import com.example.demo.domain.Consumer;
import com.example.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service实现类
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    /**
     * 增加
     *
     * @param consumer
     * @return
     */
    @Override
    public boolean insert(Consumer consumer) {
        return consumerMapper.insert(consumer)>0;
    }

    /**
     * 修改
     *
     * @param consumer
     * @return
     */
    @Override
    public boolean update(Consumer consumer) {
        return consumerMapper.update(consumer)>0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return consumerMapper.delete(id)>0;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public Consumer selectByPrimaryKey(Integer id) {
        return consumerMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Consumer> allConsumer() {
        return consumerMapper.allConsumer();
    }

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    @Override
    public List<Consumer> getByUsername(String username) {
        return consumerMapper.getByUsername(username);
    }

    /**
     * 验证密码
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean verifyPassword(String username, String password) {
        return consumerMapper.verifyPassword(username,password)>0;
    }
}
