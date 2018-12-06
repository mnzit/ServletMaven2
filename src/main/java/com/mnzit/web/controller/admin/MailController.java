/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller.admin;

import com.mnzit.web.controller.Controller;
import com.mnzit.web.entity.Mailer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "mail", urlPatterns = {"/mail/*"})
public class MailController extends Controller{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mailer m = new Mailer();
        int i = 1;
        String from = "enquire@creators.institute";
        String to = "mnzitshakya@gmail.com";
        String host = "smtp.vianet.com.np";
        String subject = "Test 2";
        String content = "Content 2";
        m.setFrom(from).setTo(to).setHost(host).setSubject(subject).setContent(content).send();
    }
    
}
