package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public BaseRespVo admindList(AdminPagingReqVo pagingReqVo) {
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

    /**
     * 创建一个新的管理员
     * @param admin
     * @return
     */
    @RequestMapping("create")
    public BaseRespVo adminCreate(@RequestBody Admin admin) {
        BaseRespVo<Admin> resp = new BaseRespVo<>();
        try {
            resp.setData(adminService.getAdCreateData(admin));
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
     * 更新一个管理员的信息
     * @param admin
     * @return
     */
    @RequestMapping("update")
    public BaseRespVo adUpdate(@RequestBody Admin admin) {
        BaseRespVo<Admin> resp = new BaseRespVo<>();
        Admin respAdmin = null;
        try {
            respAdmin = adminService.getAdminUpdateData(admin);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setErrno(502);
            resp.setErrmsg("系统内部错误");
            return resp;
        }
        resp.setData(respAdmin);
        resp.setErrno(0);
        resp.setErrmsg("成功");
        return resp;
    }

    /**
     * 逻辑删除某个管理员
     * @param admin
     * @return
     */
    @RequestMapping("delete")
    public BaseRespVo adDelete(@RequestBody Admin admin) {
        BaseRespVo resp = new BaseRespVo<>();
        try {
            adminService.deleteAdById(admin.getId());
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
