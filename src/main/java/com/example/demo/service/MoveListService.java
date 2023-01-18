package com.example.demo.service;

import com.example.demo.domain.MoveList;

import java.util.List;

/**
 * 收藏夹接口
 */
public interface MoveListService {
    /**
     * 增加
     * @param moveList
     * @return
     */
    public boolean insert(MoveList moveList);

    /**
     * 修改
     * @param moveList
     * @return
     */
    public boolean update(MoveList moveList);

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
    public MoveList selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<MoveList> allMoveList();

    /**
     * 模糊查询
     * @param title
     * @return
     */
    public List<MoveList> moveListOfTitle(String title);

}
