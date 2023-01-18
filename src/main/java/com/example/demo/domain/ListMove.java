package com.example.demo.domain;

import java.io.Serializable;

/**
 * 收藏夹内容
 */
public class ListMove implements Serializable {
    //主键
    private Integer id;
    //电影id
    private Integer moveId;
    //收藏夹id
    private Integer moveListId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoveId() {
        return moveId;
    }

    public void setMoveId(Integer moveId) {
        this.moveId = moveId;
    }

    public Integer getMoveListId() {
        return moveListId;
    }

    public void setMoveListId(Integer moveListId) {
        this.moveListId = moveListId;
    }
}
