package com.example.demo.service.impl;

import com.example.demo.dao.MoveListMapper;
import com.example.demo.domain.MoveList;
import com.example.demo.service.MoveListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收藏夹Service实现类
 */
@Service
public class MoveListServiceImpl implements MoveListService {

    @Autowired
    private MoveListMapper moveListMapper;

    /**
     * 增加
     *
     * @param moveList
     * @return
     */
    @Override
    public boolean insert(MoveList moveList) {
        return moveListMapper.insert(moveList)>0;
    }

    /**
     * 修改
     *
     * @param moveList
     * @return
     */
    @Override
    public boolean update(MoveList moveList) {
        return moveListMapper.update(moveList)>0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return moveListMapper.delete(id)>0;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public MoveList selectByPrimaryKey(Integer id) {
        return moveListMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<MoveList> allMoveList() {
        return moveListMapper.allMoveList();
    }

    /**
     * 模糊查询
     *
     * @param title
     * @return
     */
    @Override
    public List<MoveList> moveListOfTitle(String title) {
        return moveListMapper.moveListOfTitle(title);
    }
}
