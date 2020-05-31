package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;


/**
 * @author viking chen
 * @date 2020/5/29 12:46
 */
@Data
public class PagingReqVo {
    private Integer page;
    private Integer limit;
    private String sort;
    private String order;

    private String goodsId;
    private Integer id;
    private String name;
    private String content;

}
