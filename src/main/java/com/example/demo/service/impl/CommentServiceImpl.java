package com.example.demo.service.impl;

import com.example.demo.dao.CommentMapper;
import com.example.demo.domain.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论Service实现
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    /**
     * 增加
     *
     * @param comment
     * @return
     */
    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insert(comment)>0;
    }

    /**
     * 修改
     *
     * @param comment
     * @return
     */
    @Override
    public boolean update(Comment comment) {
        return commentMapper.update(comment)>0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return commentMapper.delete(id)>0;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }

    /**
     * 查询某个电影下的评论
     *
     * @param moveId
     * @return
     */
    @Override
    public List<Comment> commentOfMoveId(Integer moveId) {
        return commentMapper.commentOfMoveId(moveId);
    }
}
