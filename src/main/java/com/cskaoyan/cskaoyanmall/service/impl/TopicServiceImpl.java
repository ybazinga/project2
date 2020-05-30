package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Brand;
import com.cskaoyan.cskaoyanmall.bean.Topic;
import com.cskaoyan.cskaoyanmall.bean.TopicExample;
import com.cskaoyan.cskaoyanmall.bean.TopicPagingReqVo;
import com.cskaoyan.cskaoyanmall.mapper.TopicMapper;
import com.cskaoyan.cskaoyanmall.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 15:35 2020/5/30
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    @Override
    public Map getTopicListData(TopicPagingReqVo topicPagingReqVo) {
        Integer page = topicPagingReqVo.getPage();
        Integer limit = topicPagingReqVo.getLimit();
        String sort = topicPagingReqVo.getSort();
        String order = topicPagingReqVo.getOrder();
        String orderClause = sort + " " + order;

        String title = topicPagingReqVo.getTitle();
        String subtitle = topicPagingReqVo.getSubtitle();
        //开启分页
        PageHelper.startPage(page, limit);
        TopicExample topicExample = new TopicExample();
        TopicExample.Criteria criteria = topicExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        // 条件查询 需要添加条件
        if (title != null) criteria.andTitleLike("%" + title + "%");
        if (subtitle != null) criteria.andSubtitleLike("%" + subtitle + "%");
        topicExample.setOrderByClause(orderClause);
        List<Topic> topicList = topicMapper.selectByExample(topicExample);
        PageInfo<Topic> pageInfo = new PageInfo<>(topicList);
        Long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("items", topicList);
        return map;
    }

    @Override
    public Topic insert(Topic topic) {
        topic.setSortOrder(0);
        topic.setDeleted(false);
        topic.setAddTime(new Date());
        topic.setUpdateTime(new Date());
        // insert标签中使用useGeneratedKey → 可以获得自增的主键
        topicMapper.insert(topic);
        return topic;
    }

    @Override
    public Topic update(Topic topic) {
        topic.setUpdateTime(new Date());
        topicMapper.updateByPrimaryKeySelective(topic);
        return topic;
    }

    @Override
    public void updateByLogicDelete(Topic topic) {
        topic.setDeleted(true);
        topicMapper.updateByPrimaryKeySelective(topic);
    }
}
