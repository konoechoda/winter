package com.example.demo.dao;


import com.example.demo.domain.MoveList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 收藏夹 dao
 */
@Repository
public interface MoveListMapper {
    /**
     * 增加
     * @param moveList
     * @return
     */
    public int insert(MoveList moveList);

    /**
     * 修改
     * @param moveList
     * @return
     */
    public int update(MoveList moveList);

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
