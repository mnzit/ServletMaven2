/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller.admin;

import com.mnzit.web.controller.Controller;
import com.mnzit.web.dao.MailTemplateDAO;
import com.mnzit.web.dao.UserDAO;
import com.mnzit.web.dao.impl.MailTemplateDAOImpl;
import com.mnzit.web.dao.impl.UserDAOImpl;
import com.mnzit.web.entity.MailTemplate;
import com.mnzit.web.entity.User;
import com.mnzit.web.util.Parser;
import java.io.IOException;
import java.io.PrintWriter;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MailTemplate template = templateDAO.getById(3);

            String event = "Free JavaScript Workshop";
            String eventDate = "24 December, 2018";
            PrintWriter writer = response.getWriter();
            Parser  parser = new Parser();
            parser.add("EVENT",event);

            for (User user : userDAO.getAll()) {
                writer.println("<div>");
                 writer.println("<h1>Email for "+user.getUserName()+"</h1>");
                 parser.add("Name",user.getUserName());
                 parser.add("EVENT_DATE",eventDate);
                writer.println(parser.parse(template.getDescription()));
                writer.println("</div>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
