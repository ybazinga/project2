package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.mapper.GoodsMapper;
import com.cskaoyan.cskaoyanmall.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    SqlSession sqlSession;

    /**
     * 判断条件查询的输入框里是否为空
     */
    private boolean isEmpty(String s){
        if (s == null || "".equals(s)){
            return true;
        }
        return false;
    }

    @Autowired
    CommonRespBaseData commonRespBaseData;
    @Override
    public CommonRespBaseData<Goods> selectGoodsList(int page, int limit, String goodsSn, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause("add_time DESC");
        if (isEmpty(goodsSn) && isEmpty(name)){
            goodsExample.createCriteria();
        }else if (!isEmpty(goodsSn) && isEmpty(name)){
            goodsExample.createCriteria().andGoodsSnLike("%"+goodsSn+"%");
        }else if (isEmpty(goodsSn) && !isEmpty(name)){
            goodsExample.createCriteria().andNameLike("%"+name+"%");
        }else if (!isEmpty(name) && !isEmpty(goodsSn)){
            goodsExample.createCriteria().andGoodsSnLike("%"+goodsSn+"%").andNameLike("%"+name+"%");;
        }
        List<Goods> goods = mapper.selectByExample(goodsExample);
        commonRespBaseData.setItems(goods);
        PageInfo<Goods> userPageInfo = new PageInfo<>(goods);
        long total = userPageInfo.getTotal();
        commonRespBaseData.setTotal(total);
        return commonRespBaseData;

    }



    @Override
    public GoodsDetails selectGoodsDetails(Integer id) {
        return null;
    }


    @Override
    public int deleteGoods(Goods goods) {
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIdEqualTo(goods.getId());
        int i = mapper.deleteByExample(goodsExample);
        return i;
    }
}
