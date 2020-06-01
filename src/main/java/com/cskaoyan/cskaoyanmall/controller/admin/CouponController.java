package com.cskaoyan.cskaoyanmall.controller.admin;

import com.cskaoyan.cskaoyanmall.bean.Ad;
import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.Coupon;
import com.cskaoyan.cskaoyanmall.bean.CouponPagingReqVo;
import com.cskaoyan.cskaoyanmall.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/30 12:53
 */
@RestController
@RequestMapping("admin/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    /**
     * 根据条件显示优惠卷list
     * @param reqVo
     * @return
     */
    @RequestMapping("list")
    public BaseRespVo listCoupon(CouponPagingReqVo reqVo) {
        BaseRespVo<Map<String,Object>> resp = new BaseRespVo<>();
        try {
            resp.setData(couponService.getCouponListData(reqVo));
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }

    /**
     * 创建一个新的广告
     * @param coupon
     * @return
     */
    @RequestMapping("create")
    public BaseRespVo couponCreate(@RequestBody Coupon coupon) {
        BaseRespVo<Coupon> resp = new BaseRespVo<>();
        try {
            resp.setData(couponService.getCouponCreateData(coupon));
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }

    /**
     * 查看某个广告的信息详情
     * @param id
     * @return
     */
    @RequestMapping("read")
    public BaseRespVo couponCreate(Integer id) {
        BaseRespVo<Coupon> resp = new BaseRespVo<>();
        try {
            resp.setData(couponService.getCouponDetailById(id));
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }

    /**
     * 根据条件显示优惠卷用户的list
     * @param reqVo
     * @return
     */
    @RequestMapping("listuser")
    public BaseRespVo listuserCoupon(CouponPagingReqVo reqVo) {
        BaseRespVo<Map<String,Object>> resp = new BaseRespVo<>();
        try {
            resp.setData(couponService.getCouponListUserData(reqVo));
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }

    /**
     * 更新优惠卷list
     * @param coupon
     * @return
     */
    @RequestMapping("update")
    public BaseRespVo couponUpdate(@RequestBody Coupon coupon) {
        BaseRespVo<Coupon> resp = new BaseRespVo<>();
        Coupon respCoupon = null;
        try {
            respCoupon = couponService.updateCoupon(coupon);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setData(respCoupon);
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }

    /**
     * 逻辑删除某个优惠券信息
     * @param ad
     * @return
     */
    @RequestMapping("delete")
    public BaseRespVo adDelete(@RequestBody Coupon coupon) {
        BaseRespVo resp = new BaseRespVo<>();
        try {
            couponService.deleteCouponById(coupon.getId());
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }





}
