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
    public BaseRespVo create(@RequestBody Keyword keyword) {
        Keyword keywordResp = keywordService.create(keyword);
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setData(keywordResp);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Keyword keyword) {
        Keyword keywordResp = keywordService.update(keyword);
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setData(keywordResp);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Keyword keyword) {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        keywordService.updateByLogicDelete(keyword);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

}
