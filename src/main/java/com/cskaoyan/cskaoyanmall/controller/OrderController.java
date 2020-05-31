package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.bean.Refund;
import com.cskaoyan.cskaoyanmall.bean.Ship;
import com.cskaoyan.cskaoyanmall.service.OrderDetailService;
import com.cskaoyan.cskaoyanmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("admin/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    /**
     * 查看订单信息
     */
    @RequestMapping("list")
    public BaseRespVo orderList(PagingReqVo pagingReqVo) {
        BaseRespVo<Map<String, Object>> respVo = new BaseRespVo<>();
        try {
            respVo.setData(orderService.getOrderListData(pagingReqVo));
        } catch (Exception e) {
            respVo.setErrno(500);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("ship")
    public BaseRespVo orderShip(@RequestBody Ship ship) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            respVo.setData(orderService.updateOrderStatus(ship));
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrmsg("发货失败");
            respVo.setErrno(201);
            return respVo;
        }

        respVo.setErrno(0);
        respVo.setErrmsg("发货成功");
        return respVo;


    }
    @RequestMapping("refund")
    public BaseRespVo orderRefund(@RequestBody Refund refund){
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setData(orderService.orderRefund(refund));
        respVo.setErrno(0);
        respVo.setErrmsg("退款成功");
        return respVo;
    }
    @RequestMapping("detail")
    public BaseRespVo orderDetail(Integer id){
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            respVo.setData(orderDetailService.getOrderDetail(id));
        }catch (Exception e){
            respVo.setErrno(404);
            respVo.setErrmsg("系统错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return  respVo;
    }


}
