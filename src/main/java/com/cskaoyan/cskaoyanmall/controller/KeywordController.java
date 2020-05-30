package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.Keyword;
import com.cskaoyan.cskaoyanmall.bean.KwListRespVo;
import com.cskaoyan.cskaoyanmall.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("admin/keyword")
public class KeywordController {
    @Autowired
    KeywordService keywordService;

    @RequestMapping("list")
    public BaseRespVo list(@RequestParam Map map) {

/*        Integer page = (Integer) map.get("page");
        Integer limit = (Integer) map.get("limit");*/
        String sort = (String) map.get("sort");
        String order = (String) map.get("order");
        System.out.println(map);
        String pageS = (String) map.get("page");
        Integer page = Integer.valueOf(pageS);
        String limitS = (String) map.get("limit");
        Integer limit = Integer.valueOf(limitS);

        KwListRespVo kwListRespVo = keywordService.list(page, limit, sort, order);
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setData(kwListRespVo);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Map map) {
        String keyword = (String) map.get("keyword");
        String url = (String) map.get("url");
        String isHotS = (String) map.get("isHot");
        Boolean isHot = Boolean.valueOf(isHotS);
        String isDefaultS = (String) map.get("isDefault");
        Boolean isDefault = Boolean.valueOf(isDefaultS);

        Keyword keyword1 = keywordService.create(keyword, url, isHot, isDefault);
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setData(keyword1);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
}
