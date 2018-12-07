/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller.admin;

import com.mnzit.web.controller.Controller;
import com.mnzit.web.dao.EventDAO;
import com.mnzit.web.dao.MailTemplateDAO;
import com.mnzit.web.dao.UserDAO;
import com.mnzit.web.dao.impl.EventDAOImpl;
import com.mnzit.web.dao.impl.MailTemplateDAOImpl;
import com.mnzit.web.dao.impl.UserDAOImpl;
import com.mnzit.web.entity.Event;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "event", urlPatterns = {"/admin/events/*"})
public class EventController extends Controller {

    private MailTemplateDAO templateDAO = new MailTemplateDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private EventDAO eventDAO = new EventDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("events", eventDAO.getAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        view("admin/events/index", request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Event event = new Event();
            event.setTitle(request.getParameter("title"));
            event.setDescription(request.getParameter("description"));
            event.setStartDate(Date.valueOf(request.getParameter("start_date")));
            event.setEndDate(Date.valueOf(request.getParameter("end_date")));
            event.setStatus(request.getParameter("status") != null);
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                event.setId(Integer.parseInt(request.getParameter("id")));
                eventDAO.update(event);
            } else {
                if(eventDAO.insert(event)==1){
                     response.sendRedirect(request.getContextPath() + "/admin/events");  
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
