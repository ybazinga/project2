package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Comment;
import com.cskaoyan.cskaoyanmall.bean.CommentPagingReqVo;

import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 11:29 2020/5/30
 */
public interface CommentService {

    Map getCommentListData(CommentPagingReqVo commentPagingReqVo);

    void updateByLogicDelete(Comment comment);
}
