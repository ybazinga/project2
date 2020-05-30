package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Coupon;
import com.cskaoyan.cskaoyanmall.bean.CouponPagingReqVo;

import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/30 12:59
 */
public interface CouponService {
    Map<String, Object> getCouponListData(CouponPagingReqVo reqVo);

    Coupon getCouponCreateData(Coupon coupon);

    Coupon getCouponDetailById(Integer id);

    Map<String, Object> getCouponListUserData(CouponPagingReqVo reqVo);

    Coupon updateCoupon(Coupon coupon);

    void deleteCouponById(Integer id);
}
