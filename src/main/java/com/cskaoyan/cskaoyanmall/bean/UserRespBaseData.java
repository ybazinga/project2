package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户管理模块查询结果data对应的bean，包含total总条数和items（查询结果）列表
 * @author  杨星
 */
@Data
@Component
public class UserRespBaseData<T> {
    /**
     * 查询结果条目数
     */
    Long total;

    /**
     * 查询结果列表
     */
    List<T> items;


}
