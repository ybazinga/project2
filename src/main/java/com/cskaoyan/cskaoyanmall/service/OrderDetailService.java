package com.cskaoyan.cskaoyanmall.service;

import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public interface OrderDetailService {
    Map<String,Object> getOrderDetail(Integer id);
}
