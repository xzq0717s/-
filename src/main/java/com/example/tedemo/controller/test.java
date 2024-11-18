package com.example.tedemo.controller;



import org.json.JSONArray;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

@Controller
public class test {
    @RequestMapping(value = "/wb", method = RequestMethod.GET)
    @ResponseBody
    public String hello() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spark_data", "xzq", "admin123");
        Statement statement = connection.createStatement();
        String show = "select * from provinceeverymonth";
        ResultSet jie = statement.executeQuery(show);
        ResultSetMetaData metaData = jie.getMetaData();
        int columnCount = metaData.getColumnCount();
        JSONArray jsonArray = new JSONArray(); // 创建一个 JSON 数组
        while (jie.next()) {
            JSONObject jsonObject = new JSONObject(); // 创建一个 JSON 对象
            List<Object> row = new ArrayList<>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object columnValue = jie.getObject(columnName);
                // 将当前列名和列值放入List中
                row.add(columnValue);
                jsonObject.put(columnName, columnValue);
            }
            jsonArray.put(jsonObject); // 将 JSON 对象添加到 JSON 数组中
            System.out.println(row); // 输出每行数据
        }

        return jsonArray.toString();
    }


}
