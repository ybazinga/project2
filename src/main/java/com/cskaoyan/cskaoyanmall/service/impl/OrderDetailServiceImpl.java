package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Order;
import com.cskaoyan.cskaoyanmall.bean.OrderGoods;
import com.cskaoyan.cskaoyanmall.bean.User;
import com.cskaoyan.cskaoyanmall.mapper.OrderGoodsMapper;
import com.cskaoyan.cskaoyanmall.mapper.OrderMapper;
import com.cskaoyan.cskaoyanmall.mapper.UserMapper;
import com.cskaoyan.cskaoyanmall.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
   OrderGoodsMapper orderGoodsMapper;
    @Autowired
   UserMapper user;
    @Autowired
   OrderMapper order;
    @Override
    public Map<String, Object> getOrderDetail(Integer id) {
        OrderGoods orderGoods = orderGoodsMapper.selectByPrimaryKey(id);
        User user1 = user.selectByid();
        Order order1 =order.selectByPrimaryKey(id);

        HashMap<String,Object> map = new HashMap<>();
        map.put("orderGoods",orderGoods);
        map.put("user",user1);
        map.put("order",order1);
        return map;
    }
}
