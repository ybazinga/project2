package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Keyword;
import com.cskaoyan.cskaoyanmall.bean.KwListRespVo;

public interface KeywordService {
    KwListRespVo list(Integer page, Integer limit, String sort, String order);

    Keyword create(Keyword keyword);

    Keyword update(Keyword keyword);

    void updateByLogicDelete(Keyword keyword);
}
