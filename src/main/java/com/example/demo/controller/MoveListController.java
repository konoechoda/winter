package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.MoveList;
import com.example.demo.service.MoveListService;
import com.example.demo.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 收藏夹控制类
 */
@RestController
@RequestMapping("/moveList")
public class MoveListController {

    @Autowired
    private MoveListService moveListService;

    /**
     * 添加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addMoveList(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String title = request.getParameter("title").trim();
        String pic = request.getParameter("pic").trim();
        String introduction = request.getParameter("introduction").trim();
        //保存到对象
        MoveList moveList = new MoveList();
        moveList.setTitle(title);
        moveList.setPic(pic);
        moveList.setIntroduction(introduction);
        boolean flag = moveListService.insert(moveList);
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
    public Object updateMoveList(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String title = request.getParameter("title").trim();
        String introduction = request.getParameter("introduction").trim();
        //保存到对象
        MoveList moveList = new MoveList();
        moveList.setId(Integer.parseInt(id));
        moveList.setTitle(title);
        moveList.setIntroduction(introduction);
        boolean flag = moveListService.update(moveList);
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
    public Object deleteMoveList(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        boolean flag = moveListService.delete(Integer.parseInt(id));
        return flag;
    }
    /**
     * 根据主键查询
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        return moveListService.selectByPrimaryKey(Integer.parseInt(id));
    }
    /**
     * 查询所以对象
     */
    @RequestMapping(value = "/allMoveList",method = RequestMethod.GET)
    public Object allMoveList(HttpServletRequest request){
        return moveListService.allMoveList();
    }
    /**
     * 模糊查询
     */
    @RequestMapping(value = "/moveListOfTitle",method = RequestMethod.GET)
    public Object moveListOfTitle(HttpServletRequest request){
        String title =request.getParameter("title").trim();
        return moveListService.moveListOfTitle("%"+title+"%");
    }

    /**
     * 上传图片
     */
    @RequestMapping(value = "/updateMoveListPic",method = RequestMethod.POST)
    public Object updateMoveListPic(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"修改失败");
            return jsonObject;
        }
        //文件名=当前时间(毫秒)加上原文件名,以避免文件名冲突
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"MoveListPic";
        //判断文件路径是否存在,若不存在则新增路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件位置
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库的相对文件位置
        String storeAvatorPath = "/img/moveListPic"+fileName;
        try {
            avatorFile.transferTo(dest);
            MoveList moveList = new MoveList();
            moveList.setId(id);
            moveList.setPic(storeAvatorPath);
            boolean flag = moveListService.update(moveList);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"修改成功");
                jsonObject.put("pic",storeAvatorPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"修改失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"修改失败"+e.getMessage());
            return jsonObject;
        }finally {
            return jsonObject;
        }
    }
}
