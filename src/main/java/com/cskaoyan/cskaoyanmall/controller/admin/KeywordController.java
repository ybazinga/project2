package com.cskaoyan.cskaoyanmall.controller.admin;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.Keyword;
import com.cskaoyan.cskaoyanmall.bean.KeywordPagingReqVo;
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
    public BaseRespVo list(KeywordPagingReqVo keywordPagingReqVo) {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        KwListRespVo kwListRespVo = null;
        try {
            kwListRespVo = keywordService.list(keywordPagingReqVo);
        } catch (Exception e) {
            e.printStackTrace();
            baseRespVo.setErrno(502);
            baseRespVo.setErrmsg("系统内部错误");
            return baseRespVo;
        }
        baseRespVo.setErrno(0);
        baseRespVo.setData(kwListRespVo);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Keyword keyword) {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();

        Keyword keywordResp = null;
        try {
            keywordResp = keywordService.create(keyword);
        } catch (Exception e) {
            baseRespVo.setErrno(502);
            baseRespVo.setErrmsg("系统内部错误");
            return baseRespVo;
        }
        baseRespVo.setErrno(0);
        baseRespVo.setData(keywordResp);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Keyword keyword) {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();

        Keyword keywordResp = null;
        try {
            keywordResp = keywordService.update(keyword);
        } catch (Exception e) {
            baseRespVo.setErrno(502);
            baseRespVo.setErrmsg("系统内部错误");
            return baseRespVo;
        }
        baseRespVo.setErrno(0);
        baseRespVo.setData(keywordResp);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Keyword keyword) {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        try {
            keywordService.updateByLogicDelete(keyword);
        } catch (Exception e) {
            baseRespVo.setErrno(502);
            baseRespVo.setErrmsg("系统内部错误");
            return baseRespVo;
        }
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

}
