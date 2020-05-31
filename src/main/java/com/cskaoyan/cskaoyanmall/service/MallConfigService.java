package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.System;
import com.cskaoyan.cskaoyanmall.bean.SystemConfigRespVo;

public interface MallConfigService {


    SystemConfigRespVo showMallConfig();

    void updateValueByName(String cskaoyan_mall_mall_name);

    void updateVlueByAddress(String cskaoyan_mall_mall_address);

    void updateVlueByPhone(String cskaoyan_mall_mall_phone);

    void updateVlueByQQ(String cskaoyan_mall_mall_qq);

    SystemConfigRespVo showExpress();

    void updateValueByFreightValue(String cskaoyan_mall_express_freight_value);

    void updateVlueByFreightMin(String cskaoyan_mall_express_freight_min);

    SystemConfigRespVo showOrderConfig();



    void updateValueByUnpaid(String cskaoyan_mall_order_unpaid);

    void updateValueByunconfirm(String cskaoyan_mall_order_unconfirm);

    void updateValueByComment(String cskaoyan_mall_order_comment);

    void updateValueByShare(String cskaoyan_mall_wx_share);

    void updateValueBybrand(String cskaoyan_mall_wx_index_brand);

    void updateValueByTopic(String cskaoyan_mall_wx_index_topic);

    void updateValueByHot(String cskaoyan_mall_wx_index_hot);

    void updateValueByGoods(String cskaoyan_mall_wx_catlog_goods);

    void updateValueByList(String cskaoyan_mall_wx_catlog_list);

    void updateValueByNew(String cskaoyan_mall_wx_index_new);

    SystemConfigRespVo showWxConfig();

}
