/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller.admin;

import com.mnzit.web.controller.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "admin",urlPatterns = {"/admin","/admin/dashboard"})
public class DashBoardController extends Controller{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().println("<h1>WELCOME TO ADMIN AREA</h1>");
    }
    
}
