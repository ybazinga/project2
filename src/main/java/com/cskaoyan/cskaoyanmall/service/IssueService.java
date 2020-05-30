package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;

import java.util.Map;

/**
 * @Auther: LJJ
 * @Date: 2020/5/30 15:09
 * @Description: TODO
 */
public interface IssueService {
    Map<String, Object> getIssueDate(PagingReqVo pagingReqVo);
}
