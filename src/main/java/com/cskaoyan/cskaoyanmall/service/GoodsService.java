package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.*;

import java.util.List;

public interface GoodsService {
    CommonRespBaseData<Goods> selectGoodsList(int page, int limit, String goodsSn, String name, String sort, String order);

    GoodsDetails selectGoodsDetails(Integer id);

    int deleteGoods(Goods goods);

    List<CategoryList> selectCategoryList();


    List<CategoryL1RespVo> selectBrandList();

    void updateGoods(GoodsDetails goodsDetails);

    void insertGoods(GoodsDetails goodsDetails);
}
