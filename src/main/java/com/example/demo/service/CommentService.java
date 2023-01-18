package com.example.demo.service;

import com.example.demo.domain.Comment;

import java.util.List;

/**
 * 评论Service接口
 */
public interface CommentService {
    /**
     * 增加
     * @param comment
     * @return
     */
    public boolean insert(Comment comment);

    /**
     * 修改
     * @param comment
     * @return
     */
    public boolean update(Comment comment);

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
    public Comment selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<Comment> allComment();

    /**
     *  查询某个电影下的评论
     * @param moveId
     * @return
     */
    public List<Comment> commentOfMoveId(Integer moveId);
}
