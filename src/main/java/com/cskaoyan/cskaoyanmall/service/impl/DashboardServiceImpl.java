package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.mapper.GoodsMapper;
import com.cskaoyan.cskaoyanmall.mapper.GoodsProductMapper;
import com.cskaoyan.cskaoyanmall.mapper.OrderMapper;
import com.cskaoyan.cskaoyanmall.mapper.UserMapper;
import com.cskaoyan.cskaoyanmall.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author viking chen
 * @date 2020/5/28 20:46
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public DashboardRespVo getGoodsUserProductOrderTotal() {
        DashboardRespVo dashboardRespVo = new DashboardRespVo();
        dashboardRespVo.setGoodsTotal(goodsMapper.countByExample(new GoodsExample()));
        dashboardRespVo.setOrderTotal(orderMapper.countByExample(new OrderExample()));
        dashboardRespVo.setProductTotal(goodsProductMapper.countByExample(new GoodsProductExample()));
        dashboardRespVo.setUserTotal(userMapper.countByExample(new UserExample()));
        return dashboardRespVo;
    }
}
