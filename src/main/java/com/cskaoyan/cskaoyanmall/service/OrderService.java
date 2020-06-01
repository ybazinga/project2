package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.bean.Refund;
import com.cskaoyan.cskaoyanmall.bean.Ship;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public interface OrderService {
    Map<String,Object> getOrderListData(PagingReqVo pagingReqVo);
    Integer updateOrderStatus(Ship ship);

    int orderRefund(Refund refund);
}
