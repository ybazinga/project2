package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Category;
import com.cskaoyan.cskaoyanmall.bean.CategoryL1RespVo;
import com.cskaoyan.cskaoyanmall.bean.CategoryRespVo;

import java.util.List;

/**
 *@Author: Lee et
 *@Date: Created in 9:00 2020/5/29
 */
public interface CategoryService {
    List<CategoryRespVo> selectByLevelWithJoin(String level);

    List<CategoryL1RespVo> selectByLevel(String level);

    void updateByLogicDelete(CategoryRespVo categoryRespVo);

    Category insert(Category category);

    void update(Category category);
}
