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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mnzit
 * @param <T>
 */
public class JdbcTemplate<T> {

    private DbConnection db = new DbConnection();

    public List<T> query(String sql, RowMapper<T> mapper) throws Exception {
        List<T> rows = new ArrayList<T>();
        db.connect();
        db.init(sql);
        ResultSet rs = db.query();
        while (rs.next()) {
            rows.add(mapper.mapRow(rs));
        }
        db.close();
        return rows;
    }

    public void addParameters(PreparedStatement pstm, Object[] params) throws SQLException {
        int i = 1;
        for (Object param : params) {
            pstm.setObject(i, param);
            i++;
        }
    }

    public T queryByObject(String sql, Object[] params, RowMapper<T> mapper) throws Exception {
        T row = null;
        db.connect();
        addParameters(db.init(sql), params);
        ResultSet rs = db.query();
        while (rs.next()) {
            row = mapper.mapRow(rs);
        }
        db.close();
        return row;
    }

    public List<T> queryAllByObject(String sql, Object[] params, RowMapper<T> mapper) throws Exception {
        List<T> rows = new ArrayList<T>();
        db.connect();
        addParameters(db.init(sql), params);
        ResultSet rs = db.query();
        while (rs.next()) {
            rows.add(mapper.mapRow(rs));
        }
        db.close();
        return rows;
    }

    public int update(String sql, Object... args) throws Exception {
        db.connect();
        addParameters(db.init(sql), args);
        int result = db.update();
        db.close();
        return result;

    }
}
