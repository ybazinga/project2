package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Comment;
import com.cskaoyan.cskaoyanmall.bean.CommentExample;
import com.cskaoyan.cskaoyanmall.bean.CommentPagingReqVo;
import com.cskaoyan.cskaoyanmall.mapper.CommentMapper;
import com.cskaoyan.cskaoyanmall.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 11:33 2020/5/30
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Map getCommentListData(CommentPagingReqVo commentPagingReqVo) {
        Integer page = commentPagingReqVo.getPage();
        Integer limit = commentPagingReqVo.getLimit();
        String sort = commentPagingReqVo.getSort();
        String order = commentPagingReqVo.getOrder();
        String orderClause = sort + " " + order;
        Integer userId = commentPagingReqVo.getUserId();
        Integer valueId = commentPagingReqVo.getValueId();
        //开启分页
        PageHelper.startPage(page,limit);
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        // 条件查询 需要添加条件
        if (userId != null) criteria.andUserIdEqualTo(userId);
        if (valueId != null) criteria.andValueIdEqualTo(valueId);
        commentExample.setOrderByClause(orderClause);
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        Long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",commentList);
        return map;
    }
}
