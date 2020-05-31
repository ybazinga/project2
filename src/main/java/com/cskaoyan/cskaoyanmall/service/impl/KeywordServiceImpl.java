package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Keyword;
import com.cskaoyan.cskaoyanmall.bean.KeywordExample;
import com.cskaoyan.cskaoyanmall.bean.KwListRespVo;
import com.cskaoyan.cskaoyanmall.mapper.KeywordMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KeywordServiceImpl implements com.cskaoyan.cskaoyanmall.service.KeywordService {

    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public KwListRespVo list(Integer page, Integer limit, String sort, String order) {
        KwListRespVo kwListRespVo = new KwListRespVo();
        //kwListRespVo.setTotal((Long) keywordMapper.countByExample(new KeywordExample()));

        KeywordExample keywordExample1 = new KeywordExample();
        keywordExample1.setOrderByClause(sort + " " + order);
        List<Keyword> keywordList = keywordMapper.selectByExample(keywordExample1);
        //开始分页
        PageHelper.startPage(page, limit);
        PageInfo<Keyword> pageInfo = new PageInfo<>(keywordList);
        long total = pageInfo.getTotal();

        kwListRespVo.setTotal(total);
        kwListRespVo.setItems(keywordList);
        return kwListRespVo;
    }

    @Override
    public Keyword create(Keyword keyword) {
        keyword.setSortOrder(100);
        keyword.setAddTime(new Date());
        keyword.setUpdateTime(new Date());
        keyword.setDeleted(false);
        keywordMapper.insert(keyword);
        return keyword;
    }

    @Override
    public Keyword update(Keyword keyword) {
        keyword.setUpdateTime(new Date());
        keywordMapper.updateByPrimaryKeySelective(keyword);
        return keyword;
    }

    @Override
    public void updateByLogicDelete(Keyword keyword) {
        keyword.setDeleted(false);
        keywordMapper.updateByPrimaryKeySelective(keyword);
    }
}
