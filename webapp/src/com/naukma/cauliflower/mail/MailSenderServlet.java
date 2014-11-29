package com.naukma.cauliflower.mail;

import com.naukma.cauliflower.entities.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Max on 27.11.2014.
 */
@WebServlet(name = "MailSenderServlet")
public class MailSenderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String fullPath = context.getRealPath("/WEB-INF/mail/");
        Writer out = response.getWriter();

        EmailSender emailSender = new EmailSender();
        /* We will receive user from DAO
        emailSender.sendEmail(new User(1,1,"mhladchuk@gmail.com","max","gladchuk","22222"),"gg","gg",

                EmailSender.getTemplate("/html-mail-template.ftl" ,fullPath));
         */
        out.write("Email sent");

    }
}