package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.System;
import com.cskaoyan.cskaoyanmall.bean.SystemConfigRespVo;
import com.cskaoyan.cskaoyanmall.service.MallConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sean yang
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("admin/config")
public class MallConfigController {

    @Autowired
    MallConfigService mallConfigService;

    @GetMapping("mall")
    public BaseRespVo mallConfig(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        SystemConfigRespVo configRespVo =  mallConfigService.showMallConfig();
        baseRespVo.setData(configRespVo);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    @PostMapping("mall")
    public BaseRespVo updateMall(@RequestBody SystemConfigRespVo configRespVo){
        BaseRespVo baseRespVo = new BaseRespVo();
        mallConfigService.updateValueByName(configRespVo.getCskaoyan_mall_mall_name());
        mallConfigService.updateVlueByAddress(configRespVo.getCskaoyan_mall_mall_address());
        mallConfigService.updateVlueByPhone(configRespVo.getCskaoyan_mall_mall_phone());
        mallConfigService.updateVlueByQQ(configRespVo.getCskaoyan_mall_mall_qq());
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }


    @GetMapping("express")
    public BaseRespVo showExpress(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        SystemConfigRespVo configRespVo =  mallConfigService.showExpress();
        baseRespVo.setData(configRespVo);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    @PostMapping("express")
    public BaseRespVo updateExpress(@RequestBody SystemConfigRespVo configRespVo){
        BaseRespVo baseRespVo = new BaseRespVo();
        mallConfigService.updateValueByFreightValue(configRespVo.getCskaoyan_mall_express_freight_value());
        mallConfigService.updateVlueByFreightMin(configRespVo.getCskaoyan_mall_express_freight_min());
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }


    @GetMapping("order")
    public BaseRespVo showOrderConfig(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        SystemConfigRespVo configRespVo =  mallConfigService.showOrderConfig();
        baseRespVo.setData(configRespVo);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }


    @PostMapping("order")
    public BaseRespVo updateOrderConfig(@RequestBody SystemConfigRespVo configRespVo){
        BaseRespVo baseRespVo = new BaseRespVo();
        mallConfigService.updateValueByunconfirm(configRespVo.getCskaoyan_mall_order_unconfirm());
        mallConfigService.updateValueByUnpaid(configRespVo.getCskaoyan_mall_order_unpaid());
        mallConfigService.updateValueByComment(configRespVo.getCskaoyan_mall_order_comment());

        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }



    @GetMapping("wx")
    public BaseRespVo showWxConfig(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        SystemConfigRespVo configRespVo =  mallConfigService.showWxConfig();
        baseRespVo.setData(configRespVo);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }


    @PostMapping("wx")
    public BaseRespVo updateWxConfig(@RequestBody SystemConfigRespVo configRespVo){
        BaseRespVo baseRespVo = new BaseRespVo();
        mallConfigService.updateValueByShare(configRespVo.getCskaoyan_mall_wx_share());
        mallConfigService.updateValueBybrand(configRespVo.getCskaoyan_mall_wx_index_brand());
        mallConfigService.updateValueByTopic(configRespVo.getCskaoyan_mall_wx_index_topic());
        mallConfigService.updateValueByHot(configRespVo.getCskaoyan_mall_wx_index_hot());
        mallConfigService.updateValueByGoods(configRespVo.getCskaoyan_mall_wx_catlog_goods());
        mallConfigService.updateValueByList(configRespVo.getCskaoyan_mall_wx_catlog_list());
        mallConfigService.updateValueByNew(configRespVo.getCskaoyan_mall_wx_index_new());
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
}
