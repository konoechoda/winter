package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Director;
import com.example.demo.service.DirectorService;
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
 * 导演电影信息控制类
 */
@RestController
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    /**
     * 添加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addDirector(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();
        String pic = request.getParameter("pic").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        //保存到对象
        Director director = new Director();
        director.setName(name);
        director.setPic(pic);
        director.setLocation(location);
        director.setIntroduction(introduction);
        boolean flag = directorService.insert(director);
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
    public Object updateDirector(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        //保存到对象
        Director director = new Director();
        director.setId(Integer.parseInt(id));
        director.setName(name);
        director.setLocation(location);
        director.setIntroduction(introduction);
        boolean flag = directorService.update(director);
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
    public Object deleteDirector(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        boolean flag = directorService.delete(Integer.parseInt(id));
        return flag;
    }
    /**
     * 根据主键查询
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        return directorService.selectByPrimaryKey(Integer.parseInt(id));
    }
    /**
     * 查询所以对象
     */
    @RequestMapping(value = "/allDirector",method = RequestMethod.GET)
    public Object allDirector(HttpServletRequest request){
        return directorService.allDirector();
    }
    /**
     * 模糊查询
     */
    @RequestMapping(value = "/directorOfName",method = RequestMethod.GET)
    public Object directorOfName(HttpServletRequest request){
        String name =request.getParameter("name").trim();
        return directorService.directorOfName("%"+name+"%");
    }
    /**
     * 上传图片
     */
    @RequestMapping(value = "/updateDirectorPic",method = RequestMethod.POST)
    public Object updateDirectorPic(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id")int id){
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
                +System.getProperty("file.separator")+"DirectorPic";
        //判断文件路径是否存在,若不存在则新增路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件位置
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库的相对文件位置
        String storeAvatorPath = "/img/directorPic"+fileName;
        try {
            avatorFile.transferTo(dest);
            Director director = new Director();
            director.setId(id);
            director.setPic(storeAvatorPath);
            boolean flag = directorService.update(director);
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
