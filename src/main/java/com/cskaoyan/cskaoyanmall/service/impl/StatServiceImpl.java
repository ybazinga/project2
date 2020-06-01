package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.mapper.StatMapper;
import com.cskaoyan.cskaoyanmall.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 9:30 2020/6/1
 */
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    StatMapper statMapper;

    @Override
    public Map getOrderStat() {
        
        Map<String, Object> map = new HashMap<>();
        ArrayList<String> columnList = new ArrayList<>();
        columnList.add("day");
        columnList.add("orders");
        columnList.add("customers");
        columnList.add("amount");
        columnList.add("pcr");
        map.put("columns",columnList);
        return null;
    }
}
