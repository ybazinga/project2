package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.mapper.AdminMapper;
import com.cskaoyan.cskaoyanmall.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/30 22:27
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Map<String, Object> getAdminListData(AdminPagingReqVo pagingReqVo) {
        Integer page = pagingReqVo.getPage();
        Integer limit = pagingReqVo.getLimit();
        String sort = pagingReqVo.getSort();
        String order = pagingReqVo.getOrder();
        String orderClause = sort + " " + order;
        String username = pagingReqVo.getUsername();
        //开启分页
        PageHelper.startPage(page,limit);
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        //条件查询
        if (username != null) criteria.andUsernameLike("%" + username + "%");
        adminExample.setOrderByClause(orderClause);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
        Long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",adminList);
        return map;
    }
}
