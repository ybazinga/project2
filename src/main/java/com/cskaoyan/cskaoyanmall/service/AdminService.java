package com.cskaoyan.cskaoyanmall.service;


import com.cskaoyan.cskaoyanmall.bean.AdminPagingReqVo;

import java.util.Map;

/**
 * @author viking chen
 * @date 2020/5/30 22:27
 */
public interface AdminService {

    Map<String, Object> getAdminListData(AdminPagingReqVo pagingReqVo);

}
