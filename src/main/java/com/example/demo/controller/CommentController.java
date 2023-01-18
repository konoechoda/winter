package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论控制类
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addComment(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId").trim();
        String moveId = request.getParameter("moveId").trim();
        String content = request.getParameter("content").trim();
        //保存到对象
        Comment comment = new Comment();
        comment.setUser_id(Integer.parseInt(userId));
        comment.setMove_id(Integer.parseInt(moveId));
        comment.setContent(content);
        boolean flag = commentService.insert(comment);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"添加失败");
        return jsonObject;
    }
    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateComment(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId").trim();
        String moveId = request.getParameter("moveId").trim();
        String content = request.getParameter("content").trim();
        //保存到对象
        Comment comment = new Comment();
        comment.setUser_id(Integer.parseInt(userId));
        comment.setMove_id(Integer.parseInt(moveId));
        comment.setContent(content);
        boolean flag = commentService.update(comment);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteComment(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        boolean flag = commentService.delete(Integer.parseInt(id));
        return flag;
    }
    /**
     * 根据主键查询
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        return commentService.selectByPrimaryKey(Integer.parseInt(id));
    }

    /**
     * 查询所以对象
     */
    @RequestMapping(value = "/allComment",method = RequestMethod.GET)
    public Object allComment(HttpServletRequest request){
        return commentService.allComment();
    }

    /**
     * 查询某个电影下的评论
     */
    @RequestMapping(value = "/commentOfMoveId",method = RequestMethod.GET)
    public Object commentOfMoveId(HttpServletRequest request){
        String moveId =request.getParameter("moveId").trim();
        return commentService.commentOfMoveId(Integer.parseInt(moveId));
    }

    /**
     * 点赞
     */
    @RequestMapping(value = "/like",method = RequestMethod.POST)
    public Object like(HttpServletRequest request){
        JSONObject jsonObject= new JSONObject();
        String id = request.getParameter("id").trim();
        String up = request.getParameter("up").trim();
        //保持到对象
        Comment comment = new Comment();
        comment.setId(Integer.parseInt(id));
        comment.setId(Integer.parseInt(up));
        boolean flag = commentService.update(comment);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }
}
