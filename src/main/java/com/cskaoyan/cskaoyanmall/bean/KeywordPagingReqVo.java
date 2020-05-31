package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

@Data
public class KeywordPagingReqVo extends PagingReqVo {
    private String keyword;
    private String url;
}
