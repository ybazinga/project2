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
 *@Author: Lee et
 *@Date: Created in 13:04 2020/5/30
 */
@MappedTypes({String[].class})
@Component
public class StringArrayTypeHandler implements TypeHandler<String[]> {
    ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, String[] strings, JdbcType jdbcType) throws SQLException {
        String stringArrayJson = objectMapper.writeValueAsString(strings);
        preparedStatement.setString(index,stringArrayJson);
    }

    @Override
    public String[] getResult(ResultSet resultSet, String columnName) throws SQLException {
        String json = resultSet.getString(columnName);
        return transfer(json);
    }

    @Override
    public String[] getResult(ResultSet resultSet, int index) throws SQLException {
        String json = resultSet.getString(index);
        return transfer(json);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int index) throws SQLException {
        String json = callableStatement.getString(index);
        return transfer(json);
    }

    private String[] transfer(String json){
        String[] stringArray = null;
        if (null == json) {
            return null;
        }
        try {
            stringArray = objectMapper.readValue(json, String[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return stringArray;
    }
}
