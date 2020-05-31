package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

/**
 * @author viking chen
 * @date 2020/5/30 12:55
 */
@Data
public class CouponPagingReqVo extends BasePagingReqVo{
    String name;
    Short type;
    Short status;

    // listUser需要的成员变量

    Integer couponId;
    Integer userId;
    //Short status; 上面有了

}
