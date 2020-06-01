package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 9:26 2020/6/1
 */
@RestController
@RequestMapping("admin/stat")
public class StatController {
    @Autowired
    StatService statService;

    @RequestMapping("order")
    public BaseRespVo getOrderStat() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Map map= statService.getOrderStat();
        respVo.setData(map);
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("goods")
    public BaseRespVo getGoodsStat() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Map map = null;
        try {
            map = statService.getGoodsSatat();
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setData(map);
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }
}
