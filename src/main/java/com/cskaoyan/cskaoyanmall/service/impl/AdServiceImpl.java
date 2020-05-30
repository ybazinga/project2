package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.mapper.AdMapper;
import com.cskaoyan.cskaoyanmall.service.AdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/29 22:26
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdMapper adMapper;

    @Override
    public Map<String, Object> getAdListData(PagingReqVo pagingReqVo) {
        Integer page = pagingReqVo.getPage();
        Integer limit = pagingReqVo.getLimit();
        String sort = pagingReqVo.getSort();
        String order = pagingReqVo.getOrder();
        String orderClause = sort + " " + order;
        String name = pagingReqVo.getName();
        String content = pagingReqVo.getContent();
        //开启分页
        PageHelper.startPage(page,limit);
        AdExample adExample = new AdExample();
        AdExample.Criteria criteria = adExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (name != null) criteria.andNameLike("%" + name + "%");
        if (content != null) criteria.andContentLike("%" + content + "%");
        adExample.setOrderByClause(orderClause);
        List<Ad> adList = adMapper.selectByExample(adExample);
        PageInfo<Ad> pageInfo = new PageInfo<>(adList);
        Long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",adList);
        return map;
    }

    @Override
    public Ad getAdCreateData(Ad ad) {
        ad.setAddTime(new Date());
        ad.setUpdateTime(new Date());
        ad.setDeleted(false);
        adMapper.insertSelective(ad);
        Integer id = adMapper.getLastInsertId();
        ad.setId(id);
        return ad;
    }
}
