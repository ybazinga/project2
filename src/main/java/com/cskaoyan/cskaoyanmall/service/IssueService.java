package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Issue;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: LJJ
 * @Date: 2020/5/30 15:09
 * @Description: TODO
 */
public interface IssueService {
    Map<String, Object> getIssueDate(PagingReqVo pagingReqVo);


    Issue getIssueCreateDate(Issue issue);

    Issue getIssueUpdateDate(Issue issue);


    void deleteIssueById(Integer id);
}
