package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理模块
 * @author 杨星
 */
@RestController
@RequestMapping("admin")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 根据参数来查询用户列表
     * @param page  当前页面
     * @param limit 每一页限制条目数
     * @param sort  按照哪个字段排序
     * @param order 按照什么方式排序
     * @return
     */
    @GetMapping("user/list")
    public BaseRespVo showUserList(@RequestParam int page,
                                   @RequestParam int limit,
                                   @RequestParam String sort,
                                   @RequestParam String order,
                                   HttpServletRequest request){
        String username = request.getParameter("username");
        String mobile = request.getParameter("mobile");
        BaseRespVo baseRespVo = new BaseRespVo();
        CommonRespBaseData<User> commonRespBaseData;
        commonRespBaseData = userService.selectUsers(page, limit, username,mobile,sort, order);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setData(commonRespBaseData);
        return baseRespVo;
    }



    @GetMapping("address/list")
    public BaseRespVo showAddressList(@RequestParam int page,
                                      @RequestParam int limit,
                                      @RequestParam String sort,
                                      @RequestParam String order,
                                      HttpServletRequest request){
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        CommonRespBaseData<Address> addressCommonRespBaseData;
        BaseRespVo baseRespVo = new BaseRespVo();
        addressCommonRespBaseData = userService.selectAddress(page,limit,userId,name,sort,order);
        baseRespVo.setData(addressCommonRespBaseData);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    @GetMapping("collect/list")
    public BaseRespVo showCollectLIst(@RequestParam int page,
                                      @RequestParam int limit,
                                      @RequestParam String sort,
                                      @RequestParam String order,
                                      HttpServletRequest request){
        String userId = request.getParameter("userId");
        String valueId = request.getParameter("valueId");
        CommonRespBaseData<Collect> collectCommonRespBaseData;
        BaseRespVo baseRespVo = new BaseRespVo();
        collectCommonRespBaseData = userService.selectCollects(page,limit,userId,valueId,sort,order);
        baseRespVo.setData(collectCommonRespBaseData);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }


    @GetMapping("footprint/list")
    public BaseRespVo showFootPrint(@RequestParam int page,
                                    @RequestParam int limit,
                                    @RequestParam String sort,
                                    @RequestParam String order,
                                    HttpServletRequest request){
        String userId = request.getParameter("userId");
        String goodsId = request.getParameter("goodsId");
        CommonRespBaseData<Footprint> footprintCommonRespBaseData;
        BaseRespVo baseRespVo = new BaseRespVo();
        footprintCommonRespBaseData = userService.selectFootPrints(page,limit,userId,goodsId,sort,order);
        baseRespVo.setData(footprintCommonRespBaseData);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    @GetMapping("history/list")
    public BaseRespVo showHistories(@RequestParam int page,
                                    @RequestParam int limit,
                                    @RequestParam String sort,
                                    @RequestParam String order,
                                    HttpServletRequest request){

        String userId = request.getParameter("userId");
        String keyword = request.getParameter("keyword");
        CommonRespBaseData<SearchHistory> searchHistoryCommonRespBaseData;
        BaseRespVo baseRespVo = new BaseRespVo();
        searchHistoryCommonRespBaseData = userService.selectHistories(page,limit,userId,keyword,sort,order);
        baseRespVo.setData(searchHistoryCommonRespBaseData);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }


    @GetMapping("feedback/list")
    public BaseRespVo showFeedBackList(@RequestParam int page,
                                    @RequestParam int limit,
                                    @RequestParam String sort,
                                    @RequestParam String order,
                                    HttpServletRequest request){

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        CommonRespBaseData<Feedback> feedbackCommonRespBaseData;
        BaseRespVo baseRespVo = new BaseRespVo();
        feedbackCommonRespBaseData = userService.selectFeedBack(page,limit,id,username,sort,order);
        baseRespVo.setData(feedbackCommonRespBaseData);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
}
