package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.DashboardRespVo;
import com.cskaoyan.cskaoyanmall.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author viking chen
 * @date 2020/5/28 20:25
 */
@RestController
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @RequestMapping("admin/dashboard")
    public BaseRespVo dashboard() {
        BaseRespVo<DashboardRespVo> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setData(dashboardService.getGoodsUserProductOrderTotal());
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
}
