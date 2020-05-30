package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.AdminPagingReqVo;
import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/30 22:26
 */
@RestController
@RequestMapping("admin/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 根据条件显示所有管理员（包括搜索）
     * @param pagingReqVo
     * @return
     */
    @RequestMapping("list")
    public BaseRespVo adList(AdminPagingReqVo pagingReqVo) {
        BaseRespVo<Map<String,Object>> resp = new BaseRespVo<>();
        try {
            resp.setData(adminService.getAdminListData(pagingReqVo));
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
