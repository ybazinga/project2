package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Brand;
import com.cskaoyan.cskaoyanmall.bean.BrandExample;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.mapper.BrandMapper;
import com.cskaoyan.cskaoyanmall.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/29 12:34
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public Map<String, Object> getBrandListData(PagingReqVo pagingReqVo) {
        Integer page = pagingReqVo.getPage();
        Integer limit = pagingReqVo.getLimit();
        String sort = pagingReqVo.getSort();
        String order = pagingReqVo.getOrder();
        String orderClause = sort + " " + order;
        Integer id = pagingReqVo.getId();
        String name = pagingReqVo.getName();
        //开启分页
        PageHelper.startPage(page,limit);
        BrandExample brandExample = new BrandExample();
        BrandExample.Criteria criteria = brandExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        // 条件查询 需要添加条件
        if (id != null) criteria.andIdEqualTo(id);
        if (name != null) criteria.andNameLike("%" + name + "%");
        brandExample.setOrderByClause(orderClause);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        Long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",brandList);
        return map;
    }

    @Override
    public Brand updateBrand(Brand brand) {
        brand.setUpdateTime(new Date());
        brandMapper.updateByPrimaryKeySelective(brand);
        return brand;
    }

    @Override
    public void deleteBrandById(Integer id) {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIdEqualTo(id);
        Brand brand = new Brand();
        brand.setDeleted(true);
        brandMapper.updateByExampleSelective(brand,brandExample);
    }

    @Transactional
    @Override
    public Brand createBrand(Brand brand) {
        brand.setAddTime(new Date());
        brand.setUpdateTime(new Date());
        brandMapper.insertSelective(brand);
        int lastInsertId = brandMapper.selectLastInsertId();
        brand.setId(lastInsertId);
        return brand;
    }
}
