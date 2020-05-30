package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

/**
 * 所有list接口接收参数的bean，
 * 如果有传入其他参数请新建一个bean并继承该类
 * @author viking chen
 * @date 2020/5/30 11:04
 */
@Data
public class BasePagingReqVo {
    public Integer page;
    public Integer limit;
    public String sort;
    public String order;
}
