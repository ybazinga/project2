package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 15:31 2020/5/30
 */
@RestController
@RequestMapping("admin/topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @RequestMapping("list")
    public BaseRespVo topicList(TopicPagingReqVo topicPagingReqVo) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Map map = null;
        try {
            map = topicService.getTopicListData(topicPagingReqVo);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setData(map);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("create")
    public BaseRespVo createTopic(@RequestBody Topic topic) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Topic topicResp = null;
        try {
            topicResp = topicService.insert(topic);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setData(topicResp);
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Topic topic) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Topic topicResp = null;
        try {
            topicResp = topicService.update(topic);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(topicResp);
        return respVo;
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Topic topic) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            topicService.updateByLogicDelete(topic);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }
}
