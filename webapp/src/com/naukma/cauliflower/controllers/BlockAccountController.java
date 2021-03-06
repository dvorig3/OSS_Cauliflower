package com.naukma.cauliflower.controllers;

import com.naukma.cauliflower.dao.DAO;
import com.naukma.cauliflower.entities.User;
import com.naukma.cauliflower.mail.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Артем on 02.12.2014.
 */
@WebServlet(name = "BlockAccountController")
public class BlockAccountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathFrom  = request.getHeader("Referer");
        User us = (User)request.getSession().getAttribute("user");
        if(us.getUserRole().equals("ADMINISTRATOR")) {
            int userIdForBlock = Integer.parseInt(request.getParameter("userIdForBlock"));
            if (DAO.INSTANCE.checkForExistingUserById(userIdForBlock)) {
                //get blocked user
                User blockedUser = DAO.INSTANCE.blockUserById(userIdForBlock);
                if (blockedUser != null) {
                    String fullPath = getServletContext().getRealPath("/WEB-INF/mail/");
                    EmailSender.sendEmail(blockedUser, EmailSender.SUBJECT_BANNED,EmailSender.BAN_ACCOUNT, EmailSender.getTemplate("/mailTemplate.ftl", fullPath));
                    //OK
                    //redirect to admin dashboard
                } else {
                    request.getSession().setAttribute("error", "System error, try again later, please");
                    response.sendRedirect(pathFrom);
                }
            } else {
                request.getSession().setAttribute("error", "Incorrect user for block");
                response.sendRedirect(pathFrom);
            }
        }else{
            request.getSession().setAttribute("error", "You don`t have permission");
            response.sendRedirect(pathFrom);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
