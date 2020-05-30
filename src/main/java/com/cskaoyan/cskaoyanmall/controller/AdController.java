package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.Ad;
import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.Brand;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.service.AdService;
import com.cskaoyan.cskaoyanmall.service.impl.AdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/29 22:13
 */
@RestController
@RequestMapping("admin/ad")
public class AdController {

    @Autowired
    AdService adService;

    /**
     * 根据条件显示所有广告页面（包括搜索）
     * @param pagingReqVo
     * @return
     */
    @RequestMapping("list")
    public BaseRespVo adList(PagingReqVo pagingReqVo) {
        BaseRespVo<Map<String,Object>> resp = new BaseRespVo<>();
        try {
            resp.setData(adService.getAdListData(pagingReqVo));
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
     * 创建一个新的广告
     * @param ad
     * @return
     */
    @RequestMapping("create")
    public BaseRespVo adCreate(@RequestBody Ad ad) {
        BaseRespVo<Ad> resp = new BaseRespVo<>();
        try {
            resp.setData(adService.getAdCreateData(ad));
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
     * 更新一个广告的信息
     * @param ad
     * @return
     */
    @RequestMapping("update")
    public BaseRespVo adUpdate(@RequestBody Ad ad) {
        BaseRespVo<Ad> resp = new BaseRespVo<>();
        try {
            adService.getAdUpdateData(ad);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setData(ad);
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }

    /**
     * 逻辑删除某个广告
     * @param ad
     * @return
     */
    @RequestMapping("delete")
    public BaseRespVo adDelete(@RequestBody Ad ad) {
        BaseRespVo resp = new BaseRespVo<>();
        try {
            adService.deleteAdById(ad.getId());
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

}
