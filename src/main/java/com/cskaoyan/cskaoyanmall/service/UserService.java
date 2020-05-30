package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.*;

public interface UserService {


    CommonRespBaseData selectUsers(int page, int limit, String username, String mobile, String sort, String order);


    CommonRespBaseData<Address> selectAddress(int page, int limit, String userId, String name, String sort, String order);

    CommonRespBaseData<Collect> selectCollects(int page, int limit, String userId, String valueId, String sort, String order);

    CommonRespBaseData<Footprint> selectFootPrints(int page, int limit, String userId, String goodsId, String sort, String order);

    CommonRespBaseData<SearchHistory> selectHistories(int page, int limit, String userId, String keyword, String sort, String order);

    CommonRespBaseData<Feedback> selectFeedBack(int page, int limit, String id, String username, String sort, String order);

}
