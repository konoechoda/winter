package com.example.demo.service;

import com.example.demo.domain.Move;

import java.util.List;

/**
 * 电影service接口
 */

public interface MoveService {
    /**
     * 增加
     * @param move
     * @return
     */
    public boolean insert(Move move);

    /**
     * 修改
     * @param move
     * @return
     */
    public boolean update(Move move);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 查询(通过id,和所有,模糊查询,根据导演id)
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
