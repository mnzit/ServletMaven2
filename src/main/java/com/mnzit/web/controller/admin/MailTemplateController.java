/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller.admin;

import com.mnzit.web.controller.Controller;
import com.mnzit.web.dao.MailTemplateDAO;
import com.mnzit.web.dao.impl.MailTemplateDAOImpl;
import com.mnzit.web.entity.MailTemplate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "mailTemplate", urlPatterns = {"/admin/mailtemplate/*"})
public class MailTemplateController extends Controller {

    private MailTemplateDAO templateDAO = new MailTemplateDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI().toLowerCase();
        String page = "index";
        if (uri.contains("/add")) {
            page = "add";
        } else if (uri.contains("/edit")) {
            page = "edit";
        } else {
            try {
                request.setAttribute("templates", templateDAO.getAll());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        view("admin/mailtemplate/" + page, request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MailTemplate template = new MailTemplate();
            template.setName(request.getParameter("name"));
            template.setDescription(request.getParameter("description"));
            template.setStatus(request.getParameter("status") != null);
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                template.setId(Integer.parseInt(request.getParameter("id")));
                templateDAO.update(template);
            } else {
                templateDAO.insert(template);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
