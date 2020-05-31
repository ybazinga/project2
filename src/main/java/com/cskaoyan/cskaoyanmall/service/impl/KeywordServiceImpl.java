package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Keyword;
import com.cskaoyan.cskaoyanmall.bean.KeywordExample;
import com.cskaoyan.cskaoyanmall.bean.KeywordPagingReqVo;
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
    public KwListRespVo list(KeywordPagingReqVo keywordPagingReqVo) {
        Integer page = keywordPagingReqVo.getPage();
        Integer limit = keywordPagingReqVo.getLimit();
        String sort = keywordPagingReqVo.getSort();
        String order = keywordPagingReqVo.getOrder();
        String orderClause = sort + " " + order;

        String keyword = keywordPagingReqVo.getKeyword();
        String url = keywordPagingReqVo.getUrl();

        //开始分页
        PageHelper.startPage(page, limit);
        KeywordExample keywordExample = new KeywordExample();
        KeywordExample.Criteria criteria = keywordExample.createCriteria();
        criteria.andDeletedEqualTo(false);//设置选择逻辑删除列不为1的
        //条件查询，添加条件
        if (keyword != null) criteria.andKeywordLike("%" + keyword + "%");
        if (url != null) criteria.andUrlLike("%" + url + "%");
        keywordExample.setOrderByClause(orderClause);
        List<Keyword> keywordList = keywordMapper.selectByExample(keywordExample);
        PageInfo<Keyword> pageInfo = new PageInfo<>(keywordList);
        long total = pageInfo.getTotal();

        KwListRespVo kwListRespVo = new KwListRespVo();
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
        //// insert标签中使用useGeneratedKey → 可以获得自增的主键，这样插入的数据里面 id 就为空了
        keywordMapper.insert(keyword);//useGeneratedKeys="true" keyProperty="id
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
