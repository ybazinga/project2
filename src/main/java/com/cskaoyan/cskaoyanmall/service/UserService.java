package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.*;

import java.util.List;

public interface UserService {


    UserRespBaseData selectUsers(int page, int limit, String username,String mobile,String sort, String order);


    UserRespBaseData<Address> selectAddress(int page, int limit, String userId, String name, String sort, String order);

    UserRespBaseData<Collect> selectCollects(int page, int limit, String userId, String valueId, String sort, String order);

    UserRespBaseData<Footprint> selectFootPrints(int page, int limit, String userId, String goodsId, String sort, String order);

    UserRespBaseData<SearchHistory> selectHistories(int page, int limit, String userId, String keyword, String sort, String order);

    UserRespBaseData<Feedback> selectFeedBack(int page, int limit, String id, String username, String sort, String order);

}
