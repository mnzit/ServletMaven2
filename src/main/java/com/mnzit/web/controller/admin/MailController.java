/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller.admin;

import com.mnzit.web.controller.Controller;
import com.mnzit.web.dao.EventDAO;
import com.mnzit.web.dao.FormDAO;
import com.mnzit.web.dao.MailTemplateDAO;
import com.mnzit.web.dao.impl.EventDAOImpl;
import com.mnzit.web.dao.impl.FormDAOImpl;
import com.mnzit.web.dao.impl.MailTemplateDAOImpl;
import com.mnzit.web.entity.Event;
import com.mnzit.web.entity.Form;
import com.mnzit.web.entity.MailTemplate;
import com.mnzit.web.entity.Mailer;
import com.mnzit.web.util.Parser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "mail", urlPatterns = {"/admin/mail/*"})
public class MailController extends Controller {

    EventDAO eventDAO = new EventDAOImpl();
    MailTemplateDAO mailTemplateDAO = new MailTemplateDAOImpl();
    MailTemplate mailTemplate = new MailTemplate();
    FormDAO formDAO = new FormDAOImpl();
    Event event = new Event();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("events", eventDAO.getAll());
            request.setAttribute("templates", mailTemplateDAO.getAll());
            Map<String,Integer> map = new HashMap<String,Integer>();  
            for(Event event:eventDAO.getAll()){
                map.put(event.getTitle(),formDAO.getAllByObject("event_id", event.getId()).size());
            }
            request.setAttribute("registered", map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        view("admin/mail/index", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int templateId = Integer.parseInt(request.getParameter("template"));
            int eventId = Integer.parseInt(request.getParameter("event"));
            mailTemplate = mailTemplateDAO.getByObject("id", templateId);
            event = eventDAO.getByObject("id", eventId);
            Mailer m = new Mailer();
            String from = "enquire@creators.institute";
            String host = "smtp.vianet.com.np";

            for (Form form : formDAO.getAllByObject("event_id", eventId)) {
                Parser parser = new Parser();
                parser.add("EVENT", event.getTitle()).add("Name", form.getFirstName()).add("EVENT_DATE", event.getStartDate().toString());
                String to = form.getEmailId();
                String subject = parser.parse(mailTemplate.getName());
                String content = parser.parse(mailTemplate.getDescription());
                m.setFrom(from).setTo(to).setHost(host).setSubject(subject).setContent(content).send();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
