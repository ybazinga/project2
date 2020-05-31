package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

import java.util.List;

@Data
public class CatAndBrandResp {
    List<CategoryList> categoryList;
    List<CategoryL1RespVo> brandList;
}
