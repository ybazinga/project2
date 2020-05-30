package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author: Lee et
 *@Date: Created in 10:35 2020/5/30
 */
@RestController
@RequestMapping("admin/comment")
public class CommentController {
    /*@Autowired
    CommentService commentService;*/

    @RequestMapping("list")
    public BaseRespVo commentList(PagingReqVo pagingReqVo) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {

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
