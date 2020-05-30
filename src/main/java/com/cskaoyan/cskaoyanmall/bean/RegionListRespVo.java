package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

import java.util.List;

/**
 * @author viking chen
 * @date 2020/5/29 9:13
 */
@Data
public class RegionListRespVo {
    Integer id;
    String name;
    Integer type;
    Integer code;
    List<RegionListRespVo> children;
}
