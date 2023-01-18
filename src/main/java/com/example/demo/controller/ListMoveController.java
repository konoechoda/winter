package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.ListMove;
import com.example.demo.service.ListMoveService;
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
 * 收藏夹内容Controller
 */
@RestController
@RequestMapping("/listMove")
public class ListMoveController {

    @Autowired
    private ListMoveService listMoveService;

    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addListMove(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        //获取参数
        String moveId = request.getParameter("moveId").trim();
        String moveListId = request.getParameter("moveListId").trim();
        ListMove listMove = new ListMove();
        listMove.setMoveId(Integer.parseInt(moveId));
        listMove.setMoveListId(Integer.parseInt(moveListId));
        boolean flag = listMoveService.insert(listMove);
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
     * 根据收藏夹 id查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/detail",method =RequestMethod.GET)
    public Object listOfMoveListId(HttpServletRequest request){
        String moveListId = request.getParameter("moveListId");
        return listMoveService.listOfMoveListId(Integer.parseInt(moveListId));
    }

    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateListMove(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        String moveId = request.getParameter("moveId").trim();
        String moveListId = request.getParameter("moveListId").trim();
        //保存到对象
        ListMove listMove = new ListMove();
        listMove.setId(Integer.parseInt(id));
        listMove.setMoveId(Integer.parseInt(moveId));
        listMove.setMoveListId(Integer.parseInt(moveListId));
        boolean flag = listMoveService.update(listMove);
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
    public Object deleteList(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        boolean flag = listMoveService.delete(Integer.parseInt(id));
        return flag;
    }

    /**
     * 删除收藏夹内电影
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteListMove",method = RequestMethod.POST)
    public Object deleteListMove(HttpServletRequest request){
        String moveId = request.getParameter("moveId").trim();
        String moveListId = request.getParameter("moveListId").trim();
        boolean flag = listMoveService.deleteByMoveIdAndMoveListId(Integer.parseInt(moveId),Integer.parseInt(moveListId));
        return flag;
    }
}
