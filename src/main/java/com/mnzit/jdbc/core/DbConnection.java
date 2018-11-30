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
import java.sql.SQLException;

/**
 *
 * @author Mnzit
 */
public class DbConnection {

    private Connection conn = null;
    private PreparedStatement pstm = null;

    public void connect() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://ec2-50-17-203-51.compute-1.amazonaws.com/d3hlap1pms3oe8?sslmode=require";
        String user = "qvecbsrmncwsze";
        String password = "2560942acfed92fdfa5adebb7b9a3ca519309ec8418d71ed81dc1f17fd3264eb";
        conn = DriverManager.getConnection(url, user, password);
    }

    public PreparedStatement init(String sql) throws SQLException {
        pstm = conn.prepareStatement(sql);
        return pstm;
    }

    public ResultSet executeQuery() throws SQLException {
        return pstm.executeQuery();
    }

    public void close() throws SQLException {

        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
            pstm = null;
        }
    }
}
