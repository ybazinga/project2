package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Issue;
import com.cskaoyan.cskaoyanmall.bean.IssueExample;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.mapper.IssueMapper;
import com.cskaoyan.cskaoyanmall.service.IssueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: LJJ
 * @Date: 2020/5/30 15:11
 * @Description: 通用问题
 */
// 写个注解，不然controller里的 @Autowired无法自动获取实例
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    @Override
    public Map<String, Object> getIssueDate(PagingReqVo pagingReqVo) {
        // 获取请求参数的参数
        Integer page = pagingReqVo.getPage();
        Integer limit = pagingReqVo.getLimit();
        String sort = pagingReqVo.getSort();
        String order = pagingReqVo.getOrder();// ???
        String orderClause = sort + " " + order;// ???
        String name = pagingReqVo.getContent();// ???
        // 开启分页,开始看不懂，沦为代码的搬运工
        PageHelper.startPage(page,limit);
        // issue里有返回Date中所需数值
        IssueExample issueExample = new IssueExample();
        IssueExample.Criteria criteria = issueExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (name != null) criteria.andQuestionLike("%"+ name + "%");
        issueExample.setOrderByClause(orderClause);//???
        List<Issue> issueList = issueMapper.selectByExample(issueExample);
        PageInfo<Issue> pageInfo = new PageInfo<>(issueList);
        Long total = pageInfo.getTotal();
        HashMap<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",issueList);
        return map;

    }
}
