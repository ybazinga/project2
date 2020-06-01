package com.cskaoyan.cskaoyanmall.controller.admin;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.GrouponRules;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.service.GrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("admin/groupon")
public class GroupController {
    @Autowired
    GrouponService grouponService;

    @RequestMapping("list")
    public BaseRespVo getGroupList(PagingReqVo pagingReqVo) {

        BaseRespVo<Map<String, Object>> respVo = new BaseRespVo<>();
        try {
            respVo.setData(grouponService.selectGroupList(pagingReqVo));
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrmsg("失败");
            respVo.setErrno(404);
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("update")
    public BaseRespVo updateGroup(@RequestBody GrouponRules grouponRules) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            respVo.setData(grouponService.updateGroup(grouponRules));
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(404);
            respVo.setErrmsg("失败");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }
    @RequestMapping("create")
    public BaseRespVo createGroupRules(@RequestBody GrouponRules grouponRules){

        BaseRespVo respVo = new BaseRespVo<>();
        try {
            respVo.setData(grouponService.createGrouponRules(grouponRules) );
        }catch (Exception e){
            e.printStackTrace();
            respVo.setErrno(631);
            respVo.setErrmsg("失败");
            return respVo;
        }

        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;

    }

    @RequestMapping("delete")
    public BaseRespVo delectGroupRules(@RequestBody GrouponRules grouponRules){
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setData(grouponService.delectGroupRules(grouponRules));
        respVo.setErrmsg("失败");
        respVo.setErrno(0);
        return  respVo;





    }



}
