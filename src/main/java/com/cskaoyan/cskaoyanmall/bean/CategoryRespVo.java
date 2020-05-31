package com.cskaoyan.cskaoyanmall.bean;

import lombok.Data;

import java.util.List;

/**
 *@Author: Lee et
 *@Date: Created in 8:56 2020/5/29
 */
@Data
public class CategoryRespVo {
    /**
     * id : 1005002
     * name : 饮食
     * keywords :
     * desc : 好吃，高颜值美食
     * iconUrl : http://yanxuan.nosdn.127.net/c9280327a3fd2374c000f6bf52dff6eb.png
     * picUrl : http://yanxuan.nosdn.127.net/fb670ff3511182833e5b035275e4ac09.png
     * level : L1
     */

    private Integer id;
    private String name;
    private String keywords;
    private String desc;
    private String iconUrl;
    private String picUrl;
    private String level;
    private List<CategoryRespVo> children;
    private Integer pid;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
