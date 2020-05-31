package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.System;
import java.util.List;

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

    @GetMapping("detail")
    public BaseRespVo goodsDetail(@RequestParam Integer id){
        BaseRespVo baseRespVo = new BaseRespVo();
        GoodsDetails goodsDetails;
        goodsDetails = goodsService.selectGoodsDetails(id);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setData(goodsDetails);
        baseRespVo.setErrno(0);
        return baseRespVo;
    }


    @PostMapping("delete")
    public BaseRespVo deleteGoods(@RequestBody Goods goods){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        int i =goodsService.deleteGoods(goods);
        if (i ==1 ){
            baseRespVo.setErrno(0);
            baseRespVo.setErrmsg("成功");
        }
        return baseRespVo;
    }


    @GetMapping("catAndBrand")
    public BaseRespVo catAndBrand(){
        BaseRespVo baseRespVo = new BaseRespVo();
        List<CategoryList> categoryList;
        categoryList = goodsService.selectCategoryList();
        CatAndBrandResp catAndBrandResp = new CatAndBrandResp();
        catAndBrandResp.setCategoryList(categoryList);
        List<CategoryL1RespVo> brands = goodsService.selectBrandList();
        catAndBrandResp.setBrandList(brands);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setData(catAndBrandResp);
        return baseRespVo;
    }

    @PostMapping("update")
    public BaseRespVo updateGoods(@RequestBody  GoodsDetails goodsDetails){
        BaseRespVo baseRespVo = new BaseRespVo();
        try {
            goodsService.updateGoods(goodsDetails);
        }catch (Exception e){
            e.printStackTrace();
        }
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    @PostMapping("create")
    public BaseRespVo createGoods(@RequestBody GoodsDetails goodsDetails){
        BaseRespVo baseRespVo = new BaseRespVo();
        try {
            goodsService.insertGoods(goodsDetails);
        }catch (Exception e){
            e.printStackTrace();
        }
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

}
