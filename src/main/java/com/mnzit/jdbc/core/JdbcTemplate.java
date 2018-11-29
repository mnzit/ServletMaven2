/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.jdbc.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mnzit
 * @param <T>
 */
public class JdbcTemplate<T> {
    public List<T> query(String sql,RowMapper<T> mapper)throws Exception{
        List<T> rows = new ArrayList<T>();
        Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://ec2-50-17-203-51.compute-1.amazonaws.com/d3hlap1pms3oe8?sslmode=require";
            String user = "qvecbsrmncwsze";
            String password = "2560942acfed92fdfa5adebb7b9a3ca519309ec8418d71ed81dc1f17fd3264eb";
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                rows.add(mapper.mapRow(rs));
            }
            conn.close();
            return rows;
    }
}
