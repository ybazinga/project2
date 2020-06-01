package com.cskaoyan.cskaoyanmall.mapper;

import com.cskaoyan.cskaoyanmall.bean.GrouponRules;
import com.cskaoyan.cskaoyanmall.bean.GrouponRulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GrouponRulesMapper {
    long countByExample(GrouponRulesExample example);

    int deleteByExample(GrouponRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GrouponRules record);

    int insertSelective(GrouponRules record);

    List<GrouponRules> selectByExample(GrouponRulesExample example);

    GrouponRules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GrouponRules record, @Param("example") GrouponRulesExample example);

    int updateByExample(@Param("record") GrouponRules record, @Param("example") GrouponRulesExample example);

    int updateByPrimaryKeySelective(GrouponRules record);

    int updateByPrimaryKey(GrouponRules record);

    int getLastInsertId();

    int delectGroupReles(@Param("id") Integer id);

    List<GrouponRules> selectByExampleDelete(@Param("grouponRulesExample") GrouponRulesExample grouponRulesExample);
}