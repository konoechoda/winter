package com.example.demo.dao;


import com.example.demo.domain.Move;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 电影 dao
 */
@Repository
public interface MoveMapper {
    /**
     * 增加
     * @param move
     * @return
     */
    public int insert(Move move);

    /**
     * 修改
     * @param move
     * @return
     */
    public int update(Move move);

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
    public Move selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<Move> allMove();

    /**
     * 模糊查询
     * @param name
     * @return
     */
    public List<Move> moveOfName(String name);

    /**
     * director_id
     * @param directorId
     * @return
     */
    public List<Move> moveOfDirector(Integer directorId);

}
