package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Keyword;
import com.cskaoyan.cskaoyanmall.bean.KeywordPagingReqVo;
import com.cskaoyan.cskaoyanmall.bean.KwListRespVo;

public interface KeywordService {
    KwListRespVo list(KeywordPagingReqVo keywordPagingReqVo);

    Keyword create(Keyword keyword);

    Keyword update(Keyword keyword);

    void updateByLogicDelete(Keyword keyword);
}
