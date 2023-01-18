package com.example.demo.domain;

import java.util.Date;

public class Comment {
    //主键
    private Integer id;
    //用户id
    private Integer user_id;
    //电影id
    private Integer move_id;
    //内容
    private String content;
    //创建时间
    private Date createTime;
    //
    private Integer up;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getMove_id() {
        return move_id;
    }

    public void setMove_id(Integer move_id) {
        this.move_id = move_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }
}
