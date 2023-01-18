package com.example.demo.service.impl;

import com.example.demo.dao.MoveMapper;
import com.example.demo.domain.Move;
import com.example.demo.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 电影Service实现类
 */
@Service
public class MoveServiceImpl implements MoveService {

    @Autowired
    private MoveMapper moveMapper;

    /**
     * 增加
     *
     * @param move
     * @return
     */
    @Override
    public boolean insert(Move move) {
        return moveMapper.insert(move)>0;
    }

    /**
     * 修改
     *
     * @param move
     * @return
     */
    @Override
    public boolean update(Move move) {
        return moveMapper.update(move)>0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return moveMapper.delete(id)>0;
    }

    /**
     * 查询(通过id,和所有,模糊查询,根据导演id)
     *
     * @param id
     * @return
     */
    @Override
    public Move selectByPrimaryKey(Integer id) {
        return moveMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Move> allMove() {
        return moveMapper.allMove();
    }

    /**
     * 模糊查询
     *
     * @param name
     * @return
     */
    @Override
    public List<Move> moveOfName(String name) {
        return moveMapper.moveOfName(name);
    }

    /**
     * director_id
     *
     * @param directorId
     * @return
     */
    @Override
    public List<Move> moveOfDirector(Integer directorId) {
        return moveMapper.moveOfDirector(directorId);
    }
}
