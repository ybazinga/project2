package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

import java.util.List;

/**
 * 杨星
 */
@Data
public class CategoryList {
    Integer value;
    String label;
    List<CategoryL1RespVo> children;
}
