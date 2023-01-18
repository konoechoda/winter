package com.example.demo.dao;

import com.example.demo.domain.Comment;

import java.util.List;

public interface CommentMapper {
    /**
     * 增加
     * @param comment
     * @return
     */
    public int insert(Comment comment);

    /**
     * 修改
     * @param comment
     * @return
     */
    public int update(Comment comment);

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
