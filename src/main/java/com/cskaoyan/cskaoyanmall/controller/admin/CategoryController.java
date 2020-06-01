package com.cskaoyan.cskaoyanmall.controller.admin;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.Category;
import com.cskaoyan.cskaoyanmall.bean.CategoryRespVo;
import com.cskaoyan.cskaoyanmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 *@Author: Lee et
 *@Date: Created in 8:33 2020/5/29
 */
@RestController
@RequestMapping("admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("list")
    public BaseRespVo list() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            respVo.setData(categoryService.selectByLevelWithJoin("L1"));
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("l1")
    public BaseRespVo l1() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            respVo.setData(categoryService.selectByLevel("L1"));
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody CategoryRespVo categoryRespVo) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            categoryService.updateByLogicDelete(categoryRespVo);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Category category) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        // 判断是否是无父类目的二级类目
        if ("L2".equals(category.getLevel()) && 0 == category.getPid()) {
            respVo.setErrno(401);
            respVo.setErrmsg("参数错误：创建二级类目必须选择一级类目");
            return respVo;
        }
        Category categoryResp = null;
        try {
            categoryResp = categoryService.insert(category);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(categoryResp);
        return respVo;
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Category category) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        if ("L2".equals(category.getLevel()) && null == category.getPid()) {
            respVo.setErrno(401);
            respVo.setErrmsg("参数错误：更新为二级类目时必须选择一级类目");
            return respVo;
        }
        try {
            categoryService.update(category);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }
}
