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
    public Category insert(Category category) {
        category.setAddTime(new Date());
        category.setUpdateTime(new Date());
        //insert标签中使用useGeneratedKey → 可以获得自增的主键
        categoryMapper.insertSelective(category);
        return category;
    }

    @Override
    public void update(Category category) {
        category.setUpdateTime(new Date());
        categoryMapper.updateByPrimaryKeySelective(category);
    }

}
