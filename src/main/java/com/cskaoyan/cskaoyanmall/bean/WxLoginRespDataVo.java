package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

/**
 *@Author: Lee et
 *@Date: Created in 16:09 2020/6/1
 */
@Data
public class WxLoginRespDataVo {
    private WxUserInfo userInfo;
    private String tokenExpire;
    private String token;
}
