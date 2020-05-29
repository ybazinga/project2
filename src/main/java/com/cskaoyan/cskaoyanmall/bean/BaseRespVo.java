package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

@Data
public class BaseRespVo<T> {

    /**
     * errno : 0
     * data : 859062cc-d49d-4730-b561-c2ff944023de
     * errmsg : 成功
     */
    private Integer errno;
    private T data;
    private String errmsg;

}
