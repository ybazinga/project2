package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Refund {
    Integer orderId;
    BigDecimal fundMoney;

}
