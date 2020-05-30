package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.mapper.CouponMapper;
import com.cskaoyan.cskaoyanmall.mapper.CouponUserMapper;
import com.cskaoyan.cskaoyanmall.service.CouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/30 12:59
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;
    @Autowired
    CouponUserMapper couponUserMapper;

    @Override
    public Map<String, Object> getCouponListData(CouponPagingReqVo reqVo) {
        Integer page = reqVo.getPage();
        Integer limit = reqVo.getLimit();
        String sort = reqVo.getSort();
        String order = reqVo.getOrder();
        String orderClause = sort + " " + order;
        String name = reqVo.getName();
        Short type = reqVo.getType();
        Short status = reqVo.getStatus();
        //开启分页
        PageHelper.startPage(page,limit);
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        // 搜索条件
        if (name != null) criteria.andNameLike("%" + name + "%");
        if (type != null) criteria.andTypeEqualTo(type);
        if (status != null) criteria.andStatusEqualTo(status);
        couponExample.setOrderByClause(orderClause);
        List<Coupon> couponList = couponMapper.selectByExample(couponExample);
        PageInfo<Coupon> pageInfo = new PageInfo<>(couponList);
        Long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",couponList);
        return map;
    }

    @Override
    public Coupon getCouponCreateData(Coupon coupon) {
        coupon.setAddTime(new Date());
        coupon.setUpdateTime(new Date());
        coupon.setDeleted(false);
        couponMapper.insertSelective(coupon);
        Integer id = couponMapper.getLastInsertId();
        coupon.setId(id);
        return coupon;
    }

    @Override
    public Coupon getCouponDetailById(Integer id) {
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        return coupon;
    }

    @Override
    public Map<String, Object> getCouponListUserData(CouponPagingReqVo reqVo) {
        Integer page = reqVo.getPage();
        Integer limit = reqVo.getLimit();
        String sort = reqVo.getSort();
        String order = reqVo.getOrder();
        String orderClause = sort + " " + order;
        Integer couponId = reqVo.getCouponId();
        Integer userId = reqVo.getUserId();
        Short status = reqVo.getStatus();
        //开启分页
        PageHelper.startPage(page,limit);
        CouponUserExample couponUserExample = new CouponUserExample();
        CouponUserExample.Criteria criteria = couponUserExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        // 搜索条件
        if (couponId != null) criteria.andCouponIdEqualTo(couponId);
        if (userId != null) criteria.andUserIdEqualTo(userId);
        if (status != null) criteria.andStatusEqualTo(status);
        couponUserExample.setOrderByClause(orderClause);
        List<CouponUser> couponUserList = couponUserMapper.selectByExample(couponUserExample);
        PageInfo<CouponUser> pageInfo = new PageInfo<>(couponUserList);
        Long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",couponUserList);
        return map;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        coupon.setUpdateTime(new Date());
        couponMapper.updateByPrimaryKeySelective(coupon);
        return coupon;
    }

    @Override
    public void deleteCouponById(Integer id) {
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andIdEqualTo(id);
        Coupon coupon = new Coupon();
        coupon.setDeleted(true);
        couponMapper.updateByExampleSelective(coupon,couponExample);
    }

}
