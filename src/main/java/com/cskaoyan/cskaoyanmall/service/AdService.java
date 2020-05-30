package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;

import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/29 22:14
 */
public interface AdService {
    Map<String, Object> getAdListData(PagingReqVo pagingReqVo);
}
