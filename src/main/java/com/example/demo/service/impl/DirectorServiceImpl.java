package com.example.demo.service.impl;

import com.example.demo.dao.DirectorMapper;
import com.example.demo.domain.Director;
import com.example.demo.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 导演电影信息Service实现类
 */
@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorMapper directorMapper;

    /**
     * 增加
     *
     * @param director
     * @return
     */
    @Override
    public boolean insert(Director director) {
        return directorMapper.insert(director)>0;
    }

    /**
     * 修改
     *
     * @param director
     * @return
     */
    @Override
    public boolean update(Director director) {
        return directorMapper.update(director)>0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return directorMapper.delete(id)>0;
    }

    /**
     * 查询(通过id,和所有)
     *
     * @param id
     * @return
     */
    @Override
    public Director selectByPrimaryKey(Integer id) {
        return directorMapper.selectByPrimaryKey(id);
    }

    /**
     * @return
     */
    @Override
    public List<Director> allDirector() {
        return directorMapper.allDirector();
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<Director> directorOfName(String name) {
        return directorMapper.directorOfName(name);
    }
}
