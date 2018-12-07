/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller;

import com.mnzit.web.dao.EventDAO;
import com.mnzit.web.dao.FormDAO;
import com.mnzit.web.dao.impl.EventDAOImpl;
import com.mnzit.web.dao.impl.FormDAOImpl;
import com.mnzit.web.entity.Event;
import com.mnzit.web.entity.Form;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "form", urlPatterns = {"/form/*"})
public class FormController extends Controller {

    private EventDAO eventDAO = new EventDAOImpl();
    private FormDAO formDAO = new FormDAOImpl();
    private Event event;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI().toLowerCase();
        try {
            event = eventDAO.getByObject("link", uri);
            if (event != null) {
                request.setAttribute("event", event);
                view("form/index", request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Form form = new Form();
        form.setFirstName(request.getParameter("first_name"));
        form.setLastName(request.getParameter("last_name"));
        form.setEmailId(request.getParameter("email_id"));
        form.setContactNo(request.getParameter("contact_no"));
        form.setEventId(event.getId());
        try {
            if (formDAO.insert(form) == 1) {
                request.setAttribute("message", "<script>You are in!</script>");
                response.sendRedirect(request.getContextPath() + "/home");  
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
