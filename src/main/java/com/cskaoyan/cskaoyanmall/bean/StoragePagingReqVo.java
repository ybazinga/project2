package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

/**
 *@Author: Lee et
 *@Date: Created in 22:47 2020/5/30
 */
@Data
public class StoragePagingReqVo extends BasePagingReqVo {
    private String key;
    private String name;
}
