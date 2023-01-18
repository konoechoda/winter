package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Consumer;
import com.example.demo.service.ConsumerService;
import com.example.demo.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户控制类
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    /**
     * 添加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addConsumer(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String sex = request.getParameter("sex").trim();
        String tel = request.getParameter("tel").trim();
        String email = request.getParameter("email").trim();
        String birth = request.getParameter("birth").trim();
        String introduction = request.getParameter("introduction").trim();
        String location = request.getParameter("location").trim();
        String avatar = request.getParameter("avatar").trim();

        if(username==null||username.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名不能为空");
            return jsonObject;
        }if(password==null||password.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"密码不能为空");
            return jsonObject;
        }
        //将生日转换为Date格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        }catch (ParseException e){
            e.printStackTrace();
        }
        //保存到对象
        Consumer consumer = new Consumer();
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        consumer.setTel(tel);
        consumer.setEmail(email);
        consumer.setBrith(birthDate);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        consumer.setAvatar(avatar);
        boolean flag = consumerService.insert(consumer);
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
    public Object updateConsumer(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String sex = request.getParameter("sex").trim();
        String tel = request.getParameter("tel").trim();
        String email = request.getParameter("email").trim();
        String birth = request.getParameter("birth").trim();
        String introduction = request.getParameter("introduction").trim();
        String location = request.getParameter("location").trim();
        if(username==null||username.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名不能为空");
            return jsonObject;
        }if(password==null||password.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"密码不能为空");
            return jsonObject;
        }
        //将生日转换为Date格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        }catch (ParseException e){
            e.printStackTrace();
        }
        //保存到对象
        Consumer consumer = new Consumer();
        consumer.setId(Integer.parseInt(id));
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        consumer.setTel(tel);
        consumer.setEmail(email);
        consumer.setBrith(birthDate);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        boolean flag = consumerService.update(consumer);
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
    public Object deleteConsumer(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        boolean flag = consumerService.delete(Integer.parseInt(id));
        return flag;
    }
    /**
     * 根据主键查询
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        return consumerService.selectByPrimaryKey(Integer.parseInt(id));
    }
    /**
     * 查询所以对象
     */
    @RequestMapping(value = "/allConsumer",method = RequestMethod.GET)
    public Object allConsumer(HttpServletRequest request){
        return consumerService.allConsumer();
    }

    /**
     * 上传图片
     */
    @RequestMapping(value = "/updateConsumerPic",method = RequestMethod.POST)
    public Object updateConsumerPic(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"修改失败");
            return jsonObject;
        }
        //文件名=当前时间(毫秒)加上原文件名,以避免文件名冲突
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"avatarImages";
        //判断文件路径是否存在,若不存在则新增路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件位置
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库的相对文件位置
        String storeAvatorPath = "/avatarImages/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Consumer consumer = new Consumer();
            consumer.setId(id);
            consumer.setAvatar(storeAvatorPath);
            boolean flag = consumerService.update(consumer);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"修改成功");
                jsonObject.put("avatar",storeAvatorPath);
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
