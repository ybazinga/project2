package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.CommonRespBaseData;
import com.cskaoyan.cskaoyanmall.bean.Goods;

public interface GoodsService {
    CommonRespBaseData<Goods> selectGoodsList(int page, int limit, String goodsSn, String name, String sort, String order);
}
