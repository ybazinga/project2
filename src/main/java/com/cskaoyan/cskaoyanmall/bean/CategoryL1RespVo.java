package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

/**
 *@Author: Lee et
 *@Date: Created in 10:16 2020/5/29
 */
@Data
public class CategoryL1RespVo {

    /**
     * value : 1008000
     * label : 配件
     */

    private Integer value;
    private String label;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
