package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

import java.util.List;

@Data
public class KwListRespVo {
    Long total;
    List<Keyword> items;
}
