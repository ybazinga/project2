package com.cskaoyan.cskaoyanmall.typehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *@Author: viking chen
 *@Date: Created in 23:24 2020/5/30
 */
@MappedTypes({Integer[].class})
@Component
public class IntegerArrayTypeHandler implements TypeHandler<Integer[]> {
    ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, Integer[] integers, JdbcType jdbcType) throws SQLException {
        String integerArrayJson = objectMapper.writeValueAsString(integers);
        preparedStatement.setString(index,integerArrayJson);
    }

    @Override
    public Integer[] getResult(ResultSet resultSet, String columnName) throws SQLException {
        String json = resultSet.getString(columnName);
        return transfer(json);
    }

    @Override
    public Integer[] getResult(ResultSet resultSet, int index) throws SQLException {
        String json = resultSet.getString(index);
        return transfer(json);
    }

    @Override
    public Integer[] getResult(CallableStatement callableStatement, int index) throws SQLException {
        String json = callableStatement.getString(index);
        return transfer(json);
    }

    private Integer[] transfer(String json){
        Integer[] integersArray = null;
        if (null == json) {
            return null;
        }
        try {
            integersArray = objectMapper.readValue(json, Integer[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return integersArray;
    }
}
