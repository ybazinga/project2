package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

@Data
public class PagingReqVo {
    private Integer page;
    private Integer limit;
    private String sort;
    private String order;
    private String goodsId;
}
