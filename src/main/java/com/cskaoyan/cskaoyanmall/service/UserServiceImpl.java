package com.cskaoyan.cskaoyanmall.service;


import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.mapper.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SqlSession sqlSession;

    @Autowired
    UserRespBaseData userRespBaseData;


    /**
     * 判断条件查询的输入框里是否为空
     */
    private boolean isEmpty(String s){
        if (s == null || "".equals(s)){
            return true;
        }
        return false;
    }


    @Override
    public UserRespBaseData selectUsers(int page, int limit, String username,String mobile,String sort, String order) {
        PageHelper.startPage(page, limit);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("add_time DESC");
        if (isEmpty(username) && isEmpty(mobile)){
            userExample.createCriteria();
        }else if (!isEmpty(username) && isEmpty(mobile)){
            userExample.createCriteria().andUsernameLike("%"+username+"%");
        }else if (isEmpty(username) && !isEmpty(mobile)){
            userExample.createCriteria().andMobileLike("%"+mobile+"%");
        }else if (!isEmpty(username) && !isEmpty(mobile)){
            userExample.createCriteria().andUsernameLike("%"+username+"%").andMobileLike("%"+mobile+"%");
        }
        List<User> users = mapper.selectByExample(userExample);
        userRespBaseData.setItems(users);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        long total = userPageInfo.getTotal();
        userRespBaseData.setTotal(total);
        return  userRespBaseData;
    }

    @Override
    public UserRespBaseData<Address> selectAddress(int page, int limit, String userId, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        AddressExample addressExample = new AddressExample();
        addressExample.setOrderByClause("add_time DESC");
        if (isEmpty(name) && isEmpty(userId)){
            addressExample.createCriteria();
        }else if (!isEmpty(name) && isEmpty(userId)){
            addressExample.createCriteria().andNameLike("%"+name+"%");
        }else if (isEmpty(name) && !isEmpty(userId)){
            addressExample.createCriteria().andUserIdEqualTo(Integer.parseInt(userId));
        }else if (!isEmpty(name) && !isEmpty(userId)){
            addressExample.createCriteria().andNameLike("%"+name+"%").andUserIdEqualTo(Integer.parseInt(userId));
        }
        List<Address> addresses = mapper.selectByExample(addressExample);
        userRespBaseData.setItems(addresses);
        PageInfo<Address> userPageInfo = new PageInfo<>(addresses);
        long total = userPageInfo.getTotal();
        userRespBaseData.setTotal(total);
        return  userRespBaseData;
    }

    @Override
    public UserRespBaseData<Collect> selectCollects(int page, int limit, String userId, String valueId, String sort, String order) {
        PageHelper.startPage(page,limit);
        CollectMapper mapper = sqlSession.getMapper(CollectMapper.class);
        CollectExample collectExample = new CollectExample();
        collectExample.setOrderByClause("add_time desc");
        if (isEmpty(userId) && isEmpty(valueId)){
            collectExample.createCriteria();
        }else if (!isEmpty(userId) && isEmpty(valueId)){
            collectExample.createCriteria().andUserIdEqualTo(Integer.parseInt(userId));
        }else if (isEmpty(userId) && !isEmpty(valueId)){
            collectExample.createCriteria().andValueIdEqualTo(Integer.parseInt(valueId));
        }else if (!isEmpty(userId) && !isEmpty(valueId)){
            collectExample.createCriteria().andUserIdEqualTo(Integer.parseInt(userId)).andValueIdEqualTo(Integer.parseInt(valueId));
        }
        List<Collect> collects = mapper.selectByExample(collectExample);
        userRespBaseData.setItems(collects);
        PageInfo<Collect> userPageInfo = new PageInfo<>(collects);
        long total = userPageInfo.getTotal();
        userRespBaseData.setTotal(total);
        return  userRespBaseData;
    }

    @Override
    public UserRespBaseData<Footprint> selectFootPrints(int page, int limit, String userId, String goodsId, String sort, String order) {
        PageHelper.startPage(page,limit);
        FootprintMapper mapper = sqlSession.getMapper(FootprintMapper.class);
        FootprintExample footprintExample = new FootprintExample();
        footprintExample.setOrderByClause("add_time desc");
        if (isEmpty(userId)  && isEmpty(goodsId)){
            footprintExample.createCriteria();
        }else if (!isEmpty(userId) && isEmpty(goodsId)){
            footprintExample.createCriteria().andUserIdEqualTo(Integer.parseInt(userId));
        }else if (!isEmpty(goodsId) && isEmpty(userId)){
            footprintExample.createCriteria().andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }else if (!isEmpty(userId) && !isEmpty(goodsId)){
            footprintExample.createCriteria().andUserIdEqualTo(Integer.parseInt(userId)).andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        List<Footprint> footprints = mapper.selectByExample(footprintExample);
        userRespBaseData.setItems(footprints);
        PageInfo<Footprint> userPageInfo = new PageInfo<>(footprints);
        long total = userPageInfo.getTotal();
        userRespBaseData.setTotal(total);
        return  userRespBaseData;
    }


    @Override
    public UserRespBaseData<SearchHistory> selectHistories(int page, int limit, String userId, String keyword, String sort, String order) {
        PageHelper.startPage(page,limit);
        SearchHistoryMapper mapper = sqlSession.getMapper(SearchHistoryMapper.class);
        SearchHistoryExample searchHistoryExample = new SearchHistoryExample();
        searchHistoryExample.setOrderByClause("add_time desc");
        if (isEmpty(userId)  && isEmpty(keyword)){
            searchHistoryExample.createCriteria();
        }else if (!isEmpty(userId) && isEmpty(keyword)){
            searchHistoryExample.createCriteria().andUserIdEqualTo(Integer.parseInt(userId));
        }else if (!isEmpty(keyword) && isEmpty(userId)){
            searchHistoryExample.createCriteria().andKeywordLike("%"+keyword+"%");
        }else if (!isEmpty(userId) && !isEmpty(keyword)){
            searchHistoryExample.createCriteria().andUserIdEqualTo(Integer.parseInt(userId)).andKeywordLike("%"+keyword+"%");
        }
        List<SearchHistory> searchHistories = mapper.selectByExample(searchHistoryExample);
        userRespBaseData.setItems(searchHistories);
        PageInfo<SearchHistory> searchHistoryPageInfo = new PageInfo<>(searchHistories);
        long total = searchHistoryPageInfo.getTotal();
        userRespBaseData.setTotal(total);
        return  userRespBaseData;

    }

    @Override
    public UserRespBaseData<Feedback> selectFeedBack(int page, int limit, String id, String username, String sort, String order) {
        PageHelper.startPage(page,limit);
        FeedbackMapper mapper = sqlSession.getMapper(FeedbackMapper.class);
        FeedbackExample feedbackExample = new FeedbackExample();
        feedbackExample.setOrderByClause("add_time desc");
        if (isEmpty(id)  && isEmpty(username)){
            feedbackExample.createCriteria();
        }else if (!isEmpty(id) && isEmpty(username)){
            feedbackExample.createCriteria().andUserIdEqualTo(Integer.parseInt(id));
        }else if (!isEmpty(username) && isEmpty(username)){
            feedbackExample.createCriteria().andUsernameLike("%"+username+"%");
        }else if (!isEmpty(id) && !isEmpty(username)){
            feedbackExample.createCriteria().andUserIdEqualTo(Integer.parseInt(id)).andUsernameLike("%"+username+"%");
        }
        List<Feedback> feedbacks = mapper.selectByExample(feedbackExample);
        userRespBaseData.setItems(feedbacks);
        PageInfo<Feedback> searchHistoryPageInfo = new PageInfo<>(feedbacks);
        long total = searchHistoryPageInfo.getTotal();
        userRespBaseData.setTotal(total);
        return  userRespBaseData;
    }
}
