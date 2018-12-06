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
import com.mnzit.web.entity.MailTemplate;
import com.mnzit.web.entity.User;
import com.mnzit.web.util.Parser;
import java.io.IOException;
import java.io.PrintWriter;
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
//        try {
//            MailTemplate template = templateDAO.getById(3);
//
//            String event = "Free JavaScript Workshop";
//            String eventDate = "24 December, 2018";
//            PrintWriter writer = response.getWriter();
//            Parser  parser = new Parser();
//            parser.add("EVENT",event);
//
//            for (User user : userDAO.getAll()) {
//                writer.println("<div>");
//                 writer.println("<h1>Email for "+user.getUserName()+"</h1>");
//                 parser.add("Name",user.getUserName());
//                 parser.add("EVENT_DATE",eventDate);
//                writer.println(parser.parse(template.getDescription()));
//                writer.println("</div>");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        try {
            request.setAttribute("events", eventDAO.getAll());
            for (Event e : eventDAO.getAll()) {
                System.out.println(e.getId());
            }
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
                eventDAO.insert(event);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
