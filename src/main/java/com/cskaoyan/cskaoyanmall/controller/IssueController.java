package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import com.cskaoyan.cskaoyanmall.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: LJJ
 * @Date: 2020/5/30 1:59
 * @Description: 商城管理：通用问题
 * OS：第一个接口比较罗里吧嗦~
 */
//Response + Controller，自动帮我转化json格式之类的
@RestController
// url路径映射
@RequestMapping("admin/issue")
public class IssueController {

    // 自动获取实例
    @Autowired
    IssueService issueService;

    /**
     * 商场管理——>通用问题——>页面显示
     * @return
     */
    // 窄化请求: admin/issue/list
    @RequestMapping("list")
    // 接收get请求参数，get请求可以直接接收
    public BaseRespVo regionList(PagingReqVo pagingReqVo) {
        // new 一个返回参数
        BaseRespVo<Map<String, Object>> resp = new BaseRespVo<>();
        // 正确获取data，就接着执行，不然抛出异常系统内部错误
        try {
            // 在issueService 里的getIssueDate方法中凑出参数
            resp.setData(issueService.getIssueDate(pagingReqVo));
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
