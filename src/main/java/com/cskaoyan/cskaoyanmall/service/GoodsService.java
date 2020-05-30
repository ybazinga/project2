package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.CommonRespBaseData;
import com.cskaoyan.cskaoyanmall.bean.Goods;
import com.cskaoyan.cskaoyanmall.bean.GoodsDetails;

public interface GoodsService {
    CommonRespBaseData<Goods> selectGoodsList(int page, int limit, String goodsSn, String name, String sort, String order);

    GoodsDetails selectGoodsDetails(Integer id);

    int deleteGoods(Goods goods);
}
