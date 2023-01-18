package com.example.demo.domain;

import java.util.Date;

/**
 * 收藏夹
 */
public class MoveList {
    //主键
    private Integer id;
    //标题
    private String title;
    //名字
    private String pic;
    //简介
    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
