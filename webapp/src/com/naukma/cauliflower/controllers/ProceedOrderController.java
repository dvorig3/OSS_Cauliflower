package com.naukma.cauliflower.controllers;

import com.naukma.cauliflower.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Max on 29.11.2014.
 */
@WebServlet(name = "CreateOrderController")
public class ProceedOrderController extends HttpServlet {
    /*
    ACK.1  ACK.2(OPTIONAL)
    ACK.3
    ACK.4
    ACK.10
    ACK.12
    SOW1
    SOW2
    SOW3

     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        // create new order
        //crate instance
        // check cable
        // create tasks
        // change tasks ctatuses
        // change instance status


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }



}
