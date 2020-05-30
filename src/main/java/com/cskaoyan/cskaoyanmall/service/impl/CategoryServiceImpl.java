package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Category;
import com.cskaoyan.cskaoyanmall.bean.CategoryExample;
import com.cskaoyan.cskaoyanmall.bean.CategoryL1RespVo;
import com.cskaoyan.cskaoyanmall.bean.CategoryRespVo;
import com.cskaoyan.cskaoyanmall.mapper.CategoryMapper;
import com.cskaoyan.cskaoyanmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@Author: Lee et
 *@Date: Created in 9:02 2020/5/29
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryRespVo> selectByLevelWithJoin(String level) {
        return categoryMapper.selectByLevelWithJoin(level);
    }

    @Override
    public List<CategoryL1RespVo> selectByLevel(String level) {
        return categoryMapper.selectByLevel(level);
    }

    @Override
    public void updateByLogicDelete(CategoryRespVo categoryRespVo) {
        Integer idParent = categoryRespVo.getId();
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(idParent);
        List<CategoryRespVo> children = categoryRespVo.getChildren();
        for (CategoryRespVo child : children) {
            idList.add(child.getId());
        }
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andIdIn(idList);
        Category category = new Category();
        category.setDeleted(true);
        categoryMapper.updateByExampleSelective(category,categoryExample);
    }

    @Override
    public void insert(Category category) {
        category.setAddTime(new Date());
        category.setUpdateTime(new Date());
        categoryMapper.insertSelective(category);
    }

    @Override
    public void update(Category category) {
        category.setUpdateTime(new Date());
        Integer id = category.getId();
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andIdEqualTo(id);
        categoryMapper.updateByExampleSelective(category,categoryExample);
    }

/*@Override
    public void update(CategoryRespVo categoryRespVo) {
        Category category = new Category();
        category.setUpdateTime(new Date());
        int id = categoryRespVo.getId();
        category.setId(id);
        category.setName(categoryRespVo.getName());
        category.setKeywords(categoryRespVo.getKeywords());
        category.setIconUrl(categoryRespVo.getIconUrl());
        category.setPicUrl(categoryRespVo.getPicUrl());
        category.setLevel(categoryRespVo.getLevel());
        category.setPid(categoryRespVo.getPid());
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andIdEqualTo(id);
        categoryMapper.updateByExampleSelective(category,categoryExample);

        // 更新children数组中的category
        List<CategoryRespVo> children = categoryRespVo.getChildren();
        for (CategoryRespVo child : children) {
        }

    }*/
}
