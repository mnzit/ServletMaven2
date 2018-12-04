/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.jdbc.core.JdbcTemplate;
import com.mnzit.jdbc.core.RowMapper;
import com.mnzit.web.dao.UserDAO;
import com.mnzit.web.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class UserDAOImpl implements UserDAO {

    JdbcTemplate<User> template = new JdbcTemplate<User>();

    public User login(String userName, String password) throws Exception {
        return template.queryByObject("SELECT * from users where username=? AND password=?", new Object[]{userName, password}, new UserMapper());
    }

    public boolean isEmailExists(String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<User> getAll() throws Exception {
        return template.query("SELECT * from users", new UserMapper());
    }

    public User getById(int id) throws Exception {
        return template.queryByObject("SELECT * from users where id=?", new Object[]{1}, new UserMapper());
    }

    public int insert(User model) throws Exception {
        String sql = "INSERT into users(username,password,email,status) VALUES(?,?,?,?)";
        return template.update(sql, new Object[]{model.getUserName(),model.getPassword(),model.getEmail(),model.isStatus()});
    }

    public int delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int update(User model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }

    }
}
