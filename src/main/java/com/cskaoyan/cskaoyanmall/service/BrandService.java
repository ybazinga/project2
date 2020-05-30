package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Brand;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;

import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/29 12:33
 */
public interface BrandService {
    Map<String, Object> getBrandListData(PagingReqVo pagingReqVo);

    void updateBrand(Brand brand);

    void deleteBrandById(Integer id);

    Brand createBrand(Brand brand);
}
