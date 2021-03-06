package com.cskaoyan.cskaoyanmall.mapper;

import com.cskaoyan.cskaoyanmall.bean.Order;
import com.cskaoyan.cskaoyanmall.bean.OrderExample;
import java.util.List;

import com.cskaoyan.cskaoyanmall.bean.OrderStat;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderStat> selectOrderStat();
}
