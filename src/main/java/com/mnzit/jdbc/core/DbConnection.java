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
        Class.forName(DbConstant.DB_DRIVER);
        conn = DriverManager.getConnection(DbConstant.DB_URL, DbConstant.DB_USER, DbConstant.DB_PASSWORD);
    }

    public PreparedStatement init(String sql) throws SQLException {
        pstm = conn.prepareStatement(sql);
        return pstm;
    }

    public ResultSet query() throws SQLException {
        return pstm.executeQuery();
    }
    
     public int update() throws SQLException {
        return pstm.executeUpdate();
    }

    public void close() throws SQLException {

        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
            pstm = null;
        }
    }
}
