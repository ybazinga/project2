package com.cskaoyan.cskaoyanmall.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @Auther: LJJ
 * @Date: 2020/6/1 11:33
 * @Description: TODO
 */
@lombok.Data
public class GoodsStat {
    // 下单货品总额
    private Double amount;

    // 下单货物数量
    private Long products;

    // 订单量
    private Integer orders;

    // 日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date day;

}
