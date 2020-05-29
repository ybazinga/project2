package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

/**
 * @author viking chen
 * @date 2020/5/28 20:39
 */
@Data
public class DashboardRespVo {
    private Long goodsTotal;
    private Long userTotal;
    private Long productTotal;
    private Long orderTotal;
}
