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

import java.util.Date;
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

    /**
     * issue/list
     * @param pagingReqVo
     * @return
     */
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

    /**
     * issue/create
     * @param issue
     * @return
     */
    @Override
    public Issue getIssueCreateDate(Issue issue) {
        // 注意去bean里把时间的格式标准化
        issue.setAddTime(new Date());
        issue.setUpdateTime(new Date());
        issue.setDeleted(false);
        //自动把id放入其中，按住ctrl，可查看insertSelective接口里面对应的mapper映射。
        // 在mapperr映射中useGeneratedKeys="true" keyProperty="id"
        issueMapper.insertSelective(issue);
        return issue;
    }

    /**
     * issue/update
     * @param issue
     * @return
     */
    @Override
    public Issue getIssueUpdateDate(Issue issue) {
        issue.setUpdateTime(new Date());
        // 根据主键来更新，Selective是判断是否为空，为空就不能更新
        issueMapper.updateByPrimaryKeySelective(issue);
        return issue;
    }

    /**
     * /issue/delete
     * @param id
     */
    @Override
    public void deleteIssueById(Integer id) {
        IssueExample issueExample = new IssueExample();
        // 相当于加了一句where id = ？
        issueExample.createCriteria().andIdEqualTo(id);
        Issue issue = new Issue();
        issue.setDeleted(true);
        issueMapper.updateByExampleSelective(issue,issueExample);
    }


}
