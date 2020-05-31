package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.Brand;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/29 12:22
 */
@RestController
@RequestMapping("admin/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    /**
     * 显示所有的品牌信息
     * @param pagingReqVo
     * @return
     */
    @RequestMapping("list")
    public BaseRespVo brandList(PagingReqVo pagingReqVo) {
        BaseRespVo<Map<String,Object>> resp = new BaseRespVo<>();
        try {
            resp.setData(brandService.getBrandListData(pagingReqVo));
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }


    /**
     * 更新某个品牌的信息
     * @param brand
     * @return
     */
    @RequestMapping("update")
    public BaseRespVo brandUpdate(@RequestBody Brand brand) {
        BaseRespVo<Brand> resp = new BaseRespVo<>();
        Brand respBrand = null;
        try {
            respBrand = brandService.updateBrand(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setData(respBrand);
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }


    /**
     * （逻辑）删除某个品牌的信息
     * @param brand
     * @return
     */
    @RequestMapping("delete")
    public BaseRespVo brandDelete(@RequestBody Brand brand) {
        BaseRespVo resp = new BaseRespVo<>();
        try {
            brandService.deleteBrandById(brand.getId());
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }

    /**
     * 创建某个品牌的信息
     * @param brand
     * @return
     */
    @RequestMapping("create")
    public BaseRespVo brandCreate(@RequestBody Brand brand) {
        BaseRespVo resp = new BaseRespVo<>();
        Brand respBrand = null;
        try {
            respBrand = brandService.createBrand(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setData(respBrand);
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }


}
