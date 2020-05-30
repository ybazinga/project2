package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.Ad;
import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
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
}
