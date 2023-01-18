package com.example.demo.service;

import java.util.List;

/**
 * 收藏夹内容Service
 */

public interface ListMoveService {
     /**
     * 增加
     * @param listMove
     * @return
     */
    public boolean insert(com.example.demo.domain.ListMove listMove);

    /**
     * 修改
     * @param listMove
     * @return
     */
    public boolean update(com.example.demo.domain.ListMove listMove);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 根据电影和收藏夹id删除
     * @param moveId
     * @param moveListId
     * @return
     */
    public boolean deleteByMoveIdAndMoveListId(Integer moveId,Integer moveListId);

    /**
     * 查询
     * @param id
     * @return
     */
    public com.example.demo.domain.ListMove selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<com.example.demo.domain.ListMove> allList();

    /**
     * 收藏夹id
     * @param moveListId
     * @return
     */
    public List<com.example.demo.domain.ListMove> listOfMoveListId(Integer moveListId);
}
