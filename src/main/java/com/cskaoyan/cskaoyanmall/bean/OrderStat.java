package com.cskaoyan.cskaoyanmall.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *@Author: Lee et
 *@Date: Created in 10:29 2020/6/1
 */
@Data
public class OrderStat {
    // 订单总额
    private Double amount;

    // 订单量
    private Long orders;

    // 下单用户数量
    private Long customers;

    // 日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date day;

    // 客单价（顾客平均购买商品的金额）
    private Double pcr;
}
