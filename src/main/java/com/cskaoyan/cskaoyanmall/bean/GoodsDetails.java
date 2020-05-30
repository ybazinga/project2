package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

import java.util.List;

@Data
public class GoodsDetails {
    Integer[]  categoryIds;
    Goods goods;
    List<GoodsAttribute> attributes;
    List<GoodsSpecification> specifications;
    List<GoodsProduct> products;
}
