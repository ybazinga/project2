package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.RegionListRespVo;
import com.cskaoyan.cskaoyanmall.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author viking chen
 * @date 2020/5/29 9:09
 */
@RestController
@RequestMapping("admin/region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @RequestMapping("list")
    public BaseRespVo<List<RegionListRespVo>> regionList() {
        BaseRespVo<List<RegionListRespVo>> resp = new BaseRespVo<>();
        try {
            resp.setData(regionService.getMultilevelRegion());
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
