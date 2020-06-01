package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.mapper.GoodsMapper;
import com.cskaoyan.cskaoyanmall.mapper.GrouponRulesMapper;
import com.cskaoyan.cskaoyanmall.service.GrouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Map<String, Object> selectGroupList(PagingReqVo pagingReqVo) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        String sort = pagingReqVo.getSort();
        Integer page = pagingReqVo.getPage();
        Integer limit = pagingReqVo.getLimit();
        String order = pagingReqVo.getOrder();
        String orderClause = sort + " " + order;
        if (pagingReqVo.getGoodsId()!=null){
           String goodsId = pagingReqVo.getGoodsId();
            int a = Integer.parseInt(goodsId);
            GrouponRulesExample.Criteria criteria = grouponRulesExample.createCriteria();
            GrouponRulesExample.Criteria criteria1 = criteria.andDeletedEqualTo(false);
            GrouponRulesExample.Criteria criteria2 = criteria.andGoodsIdEqualTo(a);
            grouponRulesExample.setOrderByClause(orderClause);
            List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
            PageInfo<GrouponRules> grouponRulesPageInfo = new PageInfo<>(grouponRules);
            long total = grouponRulesPageInfo.getTotal();

            HashMap<String, Object> map = new HashMap<>();
            map.put("total", total);
            map.put("items", grouponRules);
            return map;
        }
       // String orderClause = sort + " " + order;

        PageHelper.startPage(page, limit);

        // GrouponExample grouponExample = new GrouponExample();
        // grouponExample.setOrderByClause(orderClause);

        GrouponRulesExample.Criteria criteria = grouponRulesExample.createCriteria();
        GrouponRulesExample.Criteria criteria1 = criteria.andDeletedEqualTo(false);
        grouponRulesExample.setOrderByClause(orderClause);
        List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
        PageInfo<GrouponRules> grouponRulesPageInfo = new PageInfo<>(grouponRules);
        long total = grouponRulesPageInfo.getTotal();

        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("items", grouponRules);
        return map;
    }

    /**
     * 修改优惠信息
     *
     * @param grouponRules
     */

    @Override
    public int updateGroup(GrouponRules grouponRules) {

        BigDecimal discount = grouponRules.getDiscount();
        Integer discountMember = grouponRules.getDiscountMember();
        Date expireTime = grouponRules.getExpireTime();
        GrouponRules updategrouponRules = new GrouponRules();
        updategrouponRules.setDiscountMember(discountMember);
        updategrouponRules.setExpireTime(expireTime);
        updategrouponRules.setDiscount(discount);
        int i = grouponRulesMapper.updateByPrimaryKeySelective(updategrouponRules);
        return i;


    }

    /**
     * 创建商品团购规则
     * groupon
     *
     * @param grouponRules
     * @return
     */

    @Override
    public GrouponRules createGrouponRules(GrouponRules grouponRules) {

       // Goods goods = goodsMapper.selectByPrimaryKey(grouponRules.getGoodsId());
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIdEqualTo(grouponRules.getGoodsId());
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        Goods goods = goodsList.get(0);
        String name = goods.getName();
        grouponRules.setGoodsName(name);
        String picUrl = goods.getPicUrl();
        grouponRules.setPicUrl(picUrl);
        grouponRules.setAddTime(new Date());
        grouponRules.setUpdateTime(new Date());
        grouponRulesMapper.insertSelective(grouponRules);
        int insertedId = grouponRulesMapper.getLastInsertId();
        grouponRules.setId(insertedId);
        return grouponRules;
    }

    /**
     * 删除
     * @param grouponRules
     * @return
     */
    @Override
    public Object delectGroupRules(GrouponRules grouponRules) {
        /**
         * 物理删除，怎么逻辑？
         */
        Boolean deleted = grouponRules.getDeleted();
        Integer id = grouponRules.getId();
        int i = grouponRulesMapper.delectGroupReles(id);

        return i;
    }

}
