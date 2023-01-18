package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Move;
import com.example.demo.service.MoveService;
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
 * 电影Controller
 */
@RestController
@RequestMapping("/move")
public class MoveController {

    @Autowired
    private MoveService moveService;

    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addMove(HttpServletRequest request, @RequestParam("file") MultipartFile mpFile){
        JSONObject jsonObject = new JSONObject();
        //获取参数
        String directorId = request.getParameter("directorId").trim();
        String name = request.getParameter("name").trim();
        String introduction = request.getParameter("introduction").trim();
        String pic = "/img/MovePic/m2.png";
        //上传电影文件
        if(mpFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"修改失败");
            return jsonObject;
        }
        //文件名=当前时间(毫秒)加上原文件名,以避免文件名冲突
        String fileName = System.currentTimeMillis()+mpFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"Move";
        //判断文件路径是否存在,若不存在则新增路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件位置
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库的相对文件位置
        String storeUrlPath = "/Move"+fileName;
        try {
            mpFile.transferTo(dest);
            Move move = new Move();
            move.setDirectorId(Integer.parseInt(directorId));
            move.setName(name);
            move.setIntroduction(introduction);
            move.setPic(pic);
            move.setUrl(storeUrlPath);
            boolean flag = moveService.insert(move);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"修改成功");
                jsonObject.put("avator",storeUrlPath);
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

    /**
     * 根据director id查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/director/detail",method =RequestMethod.GET)
    public Object moveOfDirector(HttpServletRequest request){
        String directorId = request.getParameter("directorId");
        return moveService.moveOfDirector(Integer.parseInt(directorId));
    }

    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateMove(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        String name = request.getParameter("name").trim();
        String introduction = request.getParameter("introduction").trim();
        //保存到对象
        Move move = new Move();
        move.setId(Integer.parseInt(id));
        move.setName(name);
        move.setIntroduction(introduction);
        boolean flag = moveService.update(move);
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
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object deleteDirector(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        boolean flag = moveService.delete(Integer.parseInt(id));
        return flag;
    }

    /**
     * 更新图片
     * @param avatorFile
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateMovePic",method = RequestMethod.POST)
    public Object updateMovePic(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id")int id){
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
                +System.getProperty("file.separator")+"MovePic";
        //判断文件路径是否存在,若不存在则新增路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件位置
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库的相对文件位置
        String storeAvatorPath = "/img/movePic"+fileName;
        try {
            avatorFile.transferTo(dest);
            Move move = new Move();
            move.setId(id);
            move.setPic(storeAvatorPath);
            boolean flag = moveService.update(move);
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
    /**
     * 更新电影文件
     * @param avatorFile
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateMoveUrl",method = RequestMethod.POST)
    public Object updateMoveUrl(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"修改失败");
            return jsonObject;
        }
        //文件名=当前时间(毫秒)加上原文件名,以避免文件名冲突
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"move";
        //判断文件路径是否存在,若不存在则新增路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件位置
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库的相对文件位置
        String storeAvatorPath = "/move"+fileName;
        try {
            avatorFile.transferTo(dest);
            Move move = new Move();
            move.setId(id);
            move.setUrl(storeAvatorPath);
            boolean flag = moveService.update(move);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"修改成功");
                jsonObject.put("avator",storeAvatorPath);
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

    /**
     * 根据电影id查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String moveId = request.getParameter("moveId");
        return moveService.selectByPrimaryKey(Integer.parseInt(moveId));
    }

    /**
     * 模糊查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/moveOfMoveName",method = RequestMethod.GET)
    public Object moveOfName(HttpServletRequest request){
        String moveName = request.getParameter("moveName");
        return moveService.moveOfName(moveName);
    }

    /**
     * 查询所有
     * @param request
     * @return
     */
    @RequestMapping(value = "/allMove",method = RequestMethod.GET)
    public Object allMove(HttpServletRequest request){
        return moveService.allMove();
    }
}
