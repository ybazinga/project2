package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Topic;
import com.cskaoyan.cskaoyanmall.bean.TopicPagingReqVo;

import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 15:35 2020/5/30
 */
public interface TopicService {
    Map getTopicListData(TopicPagingReqVo topicPagingReqVo);

    Topic insert(Topic topic);

    Topic update(Topic topic);

    void updateByLogicDelete(Topic topic);
}
