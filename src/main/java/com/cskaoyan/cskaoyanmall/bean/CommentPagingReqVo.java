package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

/**
 *@Author: Lee et
 *@Date: Created in 11:25 2020/5/30
 */
@Data
public class CommentPagingReqVo extends BasePagingReqVo {
    private Integer userId;
    private Integer valueId;
}
