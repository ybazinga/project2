package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 10:35 2020/5/30
 */
@RestController
@RequestMapping("admin/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("list")
    public BaseRespVo commentList(CommentPagingReqVo commentPagingReqVo) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Map map = null;
        try {
            map = commentService.getCommentListData(commentPagingReqVo);
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
    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Comment comment) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            commentService.updateByLogicDelete(comment);
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
