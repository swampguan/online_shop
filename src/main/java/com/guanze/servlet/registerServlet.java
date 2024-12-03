package com.guanze.servlet;

import com.guanze.pojo.user;
import com.guanze.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("username");
         String password = req.getParameter("password");
         String email = req.getParameter("email");


        userService userService = new userService();
        user user_=userService.Register(name,password,email);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        System.out.println(user_);

        if(user_!=null)
        {
            writer.write("register success");
            writer.write(" <p>back to  <a href=\"login.jsp\">Login</a> now!</p>");
        }
        else
        {
            writer.write("register failed");
            writer.write(" <p>back to  <a href=\"register.html\">Register</a> now!</p>");
            writer.write(" <p>back to  <a href=\"login.jsp\">Login</a> now!</p>");
        }


    }
}
