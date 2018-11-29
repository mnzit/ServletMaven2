/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller;

import com.mnzit.jdbc.core.JdbcTemplate;
import com.mnzit.jdbc.core.RowMapper;
import com.mnzit.web.entity.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "home", urlPatterns = {"/", "/home"})
public class HomeController extends Controller {

    JdbcTemplate<User> template = new JdbcTemplate<User>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", template.query("SELECT * from users", new RowMapper<User>() {
                public User mapRow(ResultSet rs) throws SQLException {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("username"));
                    return user;
                }
            }));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        view("home/index", request, response);

    }

}
