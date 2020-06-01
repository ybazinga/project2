package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.OrderExample;
import com.cskaoyan.cskaoyanmall.bean.UserExample;
import com.cskaoyan.cskaoyanmall.bean.OrderStat;
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
