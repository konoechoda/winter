package com.example.demo.dao;


import com.example.demo.domain.ListMove;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 电影 dao
 */
@Repository
public interface ListMoveMapper {
    /**
     * 增加
     * @param listMove
     * @return
     */
    public int insert(ListMove listMove);

    /**
     * 修改
     * @param listMove
     * @return
     */
    public int update(ListMove listMove);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 根据电影id和收藏夹id删除
     * @param moveId
     * @param moveListId
     * @return
     */
    public int deleteByMoveIdAndMoveListId(Integer moveId,Integer moveListId);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public ListMove selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<ListMove> allList();

    /**
     * 收藏夹id
     * @param moveListId
     * @return
     */
    public List<ListMove> listOfMoveListId(Integer moveListId);

}
