package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.GrouponRules;
import com.cskaoyan.cskaoyanmall.bean.PagingReqVo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Map;
@Component
public interface GrouponService {
    Map<String, Object> selectGroupList(PagingReqVo pagingReqVo);

    int updateGroup(GrouponRules grouponRules);

    GrouponRules createGrouponRules(GrouponRules grouponRules);

   Object delectGroupRules(GrouponRules grouponRules);
}
