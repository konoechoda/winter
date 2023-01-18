package com.example.demo.service;

import com.example.demo.domain.Director;

import java.util.List;

/**
 * 导演电影信息service接口
 */
public interface DirectorService {
    /**
     * 增加
     * @param director
     * @return
     */
    public boolean insert(Director director);

    /**
     * 修改
     * @param director
     * @return
     */
    public boolean update(Director director);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 查询(通过id,和所有)
     * @param id
     * @return
     */
    public Director selectByPrimaryKey(Integer id);
    public List<Director> allDirector();
    public List<Director> directorOfName(String name);

}
