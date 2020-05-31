package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.SystemConfigRespVo;
import com.cskaoyan.cskaoyanmall.mapper.SystemMapper;
import com.cskaoyan.cskaoyanmall.service.MallConfigService;
import org.apache.commons.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author sean yang
 */
@SuppressWarnings("ALL")
@Service
public class MallConfigServiceImpl implements MallConfigService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public SystemConfigRespVo showMallConfig() {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        String cskaoyanMallName = systemMapper.selectName();
        String cskaoyanMallAddress = systemMapper.selectAddress();
        String cskaoyanMallQQ = systemMapper.selectQQ();
        String phone =  systemMapper.selectPhone();

        SystemConfigRespVo configRespVo = new SystemConfigRespVo();
        configRespVo.setCskaoyan_mall_mall_name(cskaoyanMallName);
        configRespVo.setCskaoyan_mall_mall_address(cskaoyanMallAddress);
        configRespVo.setCskaoyan_mall_mall_phone(phone);
        configRespVo.setCskaoyan_mall_mall_qq(cskaoyanMallQQ);
        return configRespVo;


    }


    @Override
    public void updateValueByName(String cskaoyan_mall_mall_name) {
        SystemMapper configMapper = sqlSession.getMapper(SystemMapper.class);
        configMapper.updateValueOfMallName(cskaoyan_mall_mall_name);
    }

    @Override
    public void updateVlueByAddress(String cskaoyan_mall_mall_address) {
        SystemMapper configMapper = sqlSession.getMapper(SystemMapper.class);
        configMapper.updateValueOfMallAdress(cskaoyan_mall_mall_address);
    }

    @Override
    public void updateVlueByPhone(String cskaoyan_mall_mall_phone) {
        SystemMapper configMapper = sqlSession.getMapper(SystemMapper.class);
        configMapper.updateValueOfMallPhone(cskaoyan_mall_mall_phone);
    }

    @Override
    public void updateVlueByQQ(String cskaoyan_mall_mall_qq) {
        SystemMapper configMapper = sqlSession.getMapper(SystemMapper.class);
        configMapper.updateValueOfMallQQ(cskaoyan_mall_mall_qq);
    }


    @Override
    public SystemConfigRespVo showExpress() {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        String freightValuue = systemMapper.selectFreightvalue();
        String freightMin = systemMapper.selectFreightMin();
        SystemConfigRespVo configRespVo = new SystemConfigRespVo();
        configRespVo.setCskaoyan_mall_express_freight_value(freightValuue);
        configRespVo.setCskaoyan_mall_express_freight_min(freightMin);
        return configRespVo;
    }

    @Override
    public void updateValueByFreightValue(String cskaoyan_mall_express_freight_value) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateVauleOfFreightValue(cskaoyan_mall_express_freight_value);
    }

    @Override
    public void updateVlueByFreightMin(String cskaoyan_mall_express_freight_min) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateVauleOfFreightMin(cskaoyan_mall_express_freight_min);
    }


    @Override
    public SystemConfigRespVo showOrderConfig() {

        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        String unconfirm = systemMapper.selectUnconfirm();
        String unpaid = systemMapper.selectUnpaid();
        String comment = systemMapper.selectComment();
        SystemConfigRespVo configRespVo = new SystemConfigRespVo();
        configRespVo.setCskaoyan_mall_order_comment(comment);
        configRespVo.setCskaoyan_mall_order_unconfirm(unconfirm);
        configRespVo.setCskaoyan_mall_order_unpaid(unpaid);
        return configRespVo;
    }

    @Override
    public void updateValueByunconfirm(String cskaoyan_mall_order_unconfirm) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfConfirm(cskaoyan_mall_order_unconfirm);
    }

    @Override
    public void updateValueByComment(String cskaoyan_mall_order_comment) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfComment(cskaoyan_mall_order_comment);
    }


    @Override
    public void updateValueByUnpaid(String cskaoyan_mall_order_unpaid) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfPaid(cskaoyan_mall_order_unpaid);
    }

    @Override
    public void updateValueByShare(String cskaoyan_mall_wx_share) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfShare(cskaoyan_mall_wx_share);
    }

    @Override
    public void updateValueBybrand(String cskaoyan_mall_wx_index_brand) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfBrand(cskaoyan_mall_wx_index_brand);
    }

    @Override
    public void updateValueByTopic(String cskaoyan_mall_wx_index_topic) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfTopic(cskaoyan_mall_wx_index_topic);
    }

    @Override
    public void updateValueByHot(String cskaoyan_mall_wx_index_hot) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfHot(cskaoyan_mall_wx_index_hot);
    }

    @Override
    public void updateValueByGoods(String cskaoyan_mall_wx_catlog_goods) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfGoods(cskaoyan_mall_wx_catlog_goods);
    }

    @Override
    public void updateValueByList(String cskaoyan_mall_wx_catlog_list) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfList(cskaoyan_mall_wx_catlog_list);
    }

    @Override
    public void updateValueByNew(String cskaoyan_mall_wx_index_new) {
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        systemMapper.updateValueOfNew(cskaoyan_mall_wx_index_new);
    }


    @Override
    public SystemConfigRespVo showWxConfig() {

        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        String cskaoyan_mall_wx_share = systemMapper.selectShare();
        String cskaoyan_mall_wx_index_brand = systemMapper.selectBrand();
        String cskaoyan_mall_wx_index_topic = systemMapper.selectTopic();
        String cskaoyan_mall_wx_index_hot = systemMapper.selectHot();
        String cskaoyan_mall_wx_catlog_goods = systemMapper.selectGoods();
        String cskaoyan_mall_wx_catlog_list = systemMapper.selectList();
        String cskaoyan_mall_wx_index_new = systemMapper.selectNew();
        SystemConfigRespVo configRespVo = new SystemConfigRespVo();
        configRespVo.setCskaoyan_mall_wx_share(cskaoyan_mall_wx_share);
        configRespVo.setCskaoyan_mall_wx_index_brand(cskaoyan_mall_wx_index_brand);
        configRespVo.setCskaoyan_mall_wx_index_topic(cskaoyan_mall_wx_index_topic);
        configRespVo.setCskaoyan_mall_wx_index_hot(cskaoyan_mall_wx_index_hot);
        configRespVo.setCskaoyan_mall_wx_catlog_goods(cskaoyan_mall_wx_catlog_goods);
        configRespVo.setCskaoyan_mall_wx_catlog_list(cskaoyan_mall_wx_catlog_list);
        configRespVo.setCskaoyan_mall_wx_index_new(cskaoyan_mall_wx_index_new);
        return configRespVo;
    }
}
