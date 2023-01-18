package com.example.demo.domain;

import java.util.Date;

/**
 * 电影
 */
public class Move {
    //主键
    private Integer id;
    //director id
    private Integer directorId;
    //名字
    private String name;
    //简介
    private String introduction;
    //创建时间
    private Date createTime;
    //更新时间
    private Date upDateTime;
    //图片
    private String pic;
    //路径 地址
    private String url;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
