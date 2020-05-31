package com.cskaoyan.cskaoyanmall.mapper;

import com.cskaoyan.cskaoyanmall.bean.System;
import com.cskaoyan.cskaoyanmall.bean.SystemConfigRespVo;
import com.cskaoyan.cskaoyanmall.bean.SystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMapper {
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);


    SystemConfigRespVo selectConfig();

    String selectName();

    String selectAddress();

    String selectQQ();

    String selectPhone();

    void updateValueOfMallName(@Param("cskaoyan_mall_mall_name") String cskaoyan_mall_mall_name);

    void updateValueOfMallAdress(@Param("cskaoyan_mall_mall_address") String cskaoyan_mall_mall_address);

    void updateValueOfMallPhone(@Param("cskaoyan_mall_mall_phone") String cskaoyan_mall_mall_phone);

    void updateValueOfMallQQ(@Param("cskaoyan_mall_mall_qq") String cskaoyan_mall_mall_qq);

    String selectFreightvalue();

    String selectFreightMin();

    void updateVauleOfFreightValue(@Param("cskaoyan_mall_express_freight_value") String cskaoyan_mall_express_freight_value);

    void updateVauleOfFreightMin(@Param("cskaoyan_mall_express_freight_min") String cskaoyan_mall_express_freight_min);

    String selectUnconfirm();

    String selectUnpaid();

    String selectComment();

    void updateValueOfConfirm(@Param("cskaoyan_mall_order_unconfirm") String cskaoyan_mall_order_unconfirm);

    void updateValueOfComment(@Param("cskaoyan_mall_order_comment") String cskaoyan_mall_order_comment);

    void updateValueOfPaid(@Param("cskaoyan_mall_order_unpaid") String cskaoyan_mall_order_unpaid);

    String selectShare();

    String selectBrand();

    String selectTopic();

    String selectHot();

    String selectGoods();

    String selectList();

    String selectNew();

    void updateValueOfShare(@Param("cskaoyan_mall_wx_share") String cskaoyan_mall_wx_share);

    void updateValueOfBrand(@Param("cskaoyan_mall_wx_index_brand") String cskaoyan_mall_wx_index_brand);

    void updateValueOfTopic(@Param("cskaoyan_mall_wx_index_topic") String cskaoyan_mall_wx_index_topic);

    void updateValueOfHot(@Param("cskaoyan_mall_wx_index_hot") String cskaoyan_mall_wx_index_hot);

    void updateValueOfGoods(@Param("cskaoyan_mall_wx_catlog_goods") String cskaoyan_mall_wx_catlog_goods);

    void updateValueOfList(@Param("cskaoyan_mall_wx_catlog_list") String cskaoyan_mall_wx_catlog_list);

    void updateValueOfNew(@Param("cskaoyan_mall_wx_index_new") String cskaoyan_mall_wx_index_new);
}
