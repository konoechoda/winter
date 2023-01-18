package com.example.demo.service.impl;

import com.example.demo.dao.ListMoveMapper;
import com.example.demo.domain.ListMove;
import com.example.demo.service.ListMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收藏夹内容Service实现类
 */
@Service
public class ListMoveServiceImpl implements ListMoveService {
    @Autowired
    private ListMoveMapper listMoveMapper;
    /**
     * 增加
     *
     * @param listMove
     * @return
     */
    @Override
    public boolean insert(ListMove listMove) {
        return listMoveMapper.insert(listMove)>0;
    }

    /**
     * 修改
     *
     * @param listMove
     * @return
     */
    @Override
    public boolean update(ListMove listMove) {
        return listMoveMapper.update(listMove)>0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return listMoveMapper.delete(id)>0;
    }

    /**
     * 根据电影和收藏夹id删除
     *
     * @param moveId
     * @param moveListId
     * @return
     */
    @Override
    public boolean deleteByMoveIdAndMoveListId(Integer moveId, Integer moveListId) {
        return listMoveMapper.deleteByMoveIdAndMoveListId(moveId,moveListId)>0;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public ListMove selectByPrimaryKey(Integer id) {
        return listMoveMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<ListMove> allList() {
        return listMoveMapper.allList();
    }

    /**
     * 收藏夹id
     *
     * @param moveListId
     * @return
     */
    @Override
    public List<ListMove> listOfMoveListId(Integer moveListId) {
        return listMoveMapper.listOfMoveListId(moveListId);
    }

}
