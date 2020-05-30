package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.CommonRespBaseData;
import com.cskaoyan.cskaoyanmall.bean.Goods;
import com.cskaoyan.cskaoyanmall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("admin/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("list")
    public BaseRespVo showGoods(@RequestParam int page,
                                @RequestParam int limit,
                                @RequestParam String sort,
                                @RequestParam String order,
                                HttpServletRequest request){
        String goodsSn = request.getParameter("goodsSn");
        String name = request.getParameter("name");
        BaseRespVo baseRespVo = new BaseRespVo();
        CommonRespBaseData<Goods> commonRespBaseData;
        commonRespBaseData = goodsService.selectGoodsList(page, limit, goodsSn,name,sort, order);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setData(commonRespBaseData);
        return baseRespVo;
    }
}
