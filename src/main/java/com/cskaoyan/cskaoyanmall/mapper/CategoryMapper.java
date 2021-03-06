package com.cskaoyan.cskaoyanmall.mapper;

import com.cskaoyan.cskaoyanmall.bean.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {

    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<CategoryRespVo> selectByLevelWithJoin(@Param("level") String level);

    List<CategoryL1RespVo> selectByLevel(@Param("level") String level);

    List<CategoryList> selectCategoryList();

    int selectPidByCategoryId(@Param("categoryId") int categoryId);
}
