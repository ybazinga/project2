package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Order;
import com.cskaoyan.cskaoyanmall.bean.OrderExample;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.mapper.OrderMapper;
import com.cskaoyan.cskaoyanmall.bean.Refund;
import com.cskaoyan.cskaoyanmall.bean.Ship;
import com.cskaoyan.cskaoyanmall.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    Order order = new Order();

    /**
     * 更新订单状态的时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
////    Date date = new Date();
 /*   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;*/
    @Override
    public Map<String, Object> getOrderListData(PagingReqVo pagingReqVo) {
        /**
         * 得到请求参数
         */
        Integer limit = pagingReqVo.getLimit();
        String order = pagingReqVo.getOrder();
        Integer page = pagingReqVo.getPage();
        String sort = pagingReqVo.getSort();
        String orderClause = sort + " " + order;
        /**
         * 限制每页的条目数
         */
        PageHelper.startPage(page, limit);
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause(orderClause);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        long total = orderPageInfo.getTotal();

        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("items", orders);
        return map;
    }


    /**
     * 修改发货状态
     *
     * @param ship
     * @return
     */
    @Override
    public Integer updateOrderStatus(Ship ship) {
        /**
         * 得到请求体的数据
         */
        Integer orderId = ship.getOrderId();
        String shipChannel = ship.getShipChannel();
        String shipSn = ship.getShipSn();
        /**
         * 将请求体里的数据封装给0rder，然后调用updateByPrimaryKeySelective方法，更改用户数据的状态
         */

        Short orderStatus = 301;
        order.setShipChannel(shipChannel);
        order.setShipSn(shipSn);
        order.setId(orderId);
        order.setOrderStatus(orderStatus);

        int i = orderMapper.updateByPrimaryKeySelective(order);
        return i;
    }

    /**
     * 退款代码
     *
     * @param refund
     * @return
     */
    @Override
    public int orderRefund(Refund refund) {
        Integer orderId = refund.getOrderId();
        BigDecimal refundMoney = refund.getFundMoney();
        BigDecimal a = new BigDecimal(0);
        order.setActualPrice(a);

        order.setId(orderId);

        short status = 203;//改变状态码为203（已退款）
        order.setOrderStatus(status);
        int i = orderMapper.updateByPrimaryKeySelective(order);
        return i;

    }
}
