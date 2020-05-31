package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

/**
 *@Author: Lee et
 *@Date: Created in 15:33 2020/5/30
 */
@Data
public class TopicPagingReqVo extends BasePagingReqVo{
    private String title;

    private String subtitle;
}
