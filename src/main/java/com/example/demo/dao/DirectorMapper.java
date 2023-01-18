package com.example.demo.dao;


import com.example.demo.domain.Director;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 导演及电影信息dao
 */
@Repository
public interface DirectorMapper {
    /**
     * 增加
     * @param director
     * @return
     */
    public int insert(Director director);

    /**
     * 修改
     * @param director
     * @return
     */
    public int update(Director director);

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
    public Director selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<Director> allDirector();

    /**
     * 模糊查询
     * @param name
     * @return
     */
    public List<Director> directorOfName(String name);

}
