package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.GoodsStat;
import com.cskaoyan.cskaoyanmall.bean.OrderStat;
import com.cskaoyan.cskaoyanmall.mapper.GoodsMapper;
import com.cskaoyan.cskaoyanmall.bean.UserStat;
import com.cskaoyan.cskaoyanmall.mapper.OrderMapper;
import com.cskaoyan.cskaoyanmall.mapper.UserMapper;
import com.cskaoyan.cskaoyanmall.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *@Author: Lee et
 *@Date: Created in 9:30 2020/6/1
 */
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map getOrderStat() {
        Map<String, Object> map = new HashMap<>();
        ArrayList<String> columnList = new ArrayList<>();
        columnList.add("day");
        columnList.add("orders");
        columnList.add("customers");
        columnList.add("amount");
        columnList.add("pcr");
        map.put("columns", columnList);

        List<OrderStat> orderStatList = orderMapper.selectOrderStat();
        map.put("rows", orderStatList);
        return map;
    }



    /**
     * /stat/goods
     * @return
     */
    @Override
    public Map getGoodsStat() {
        // 用map类型来接收
        Map<Object, Object> map = new HashMap<>();
        ArrayList<String> columList = new ArrayList<>();
        columList.add("day");
        columList.add("orders");
        columList.add("products");
        columList.add("amount");
        map.put("columns", columList);

        // 此处存疑，对于下单货品数量、下单货品总额定义不清楚。需根据前端确定
        List<GoodsStat> goodsStatList = goodsMapper.selectGoodsStat();
        map.put("rows", goodsStatList);
        return map;
    }

    @Override
    public Map getUserStat() {
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> columnList = new ArrayList<>();
        columnList.add("day");
        columnList.add("users");
        map.put("columns", columnList);

        List<UserStat> userStatList = userMapper.selectUserStat();
        map.put("rows", userStatList);
        return map;
    }
}
