package com.cskaoyan.cskaoyanmall.controller.admin;

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
        BaseRespVo<DashboardRespVo> resp = new BaseRespVo<>();
        try {
            resp.setData(dashboardService.getGoodsUserProductOrderTotal());
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
