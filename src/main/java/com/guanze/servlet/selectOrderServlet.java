package com.guanze.servlet;

import com.guanze.pojo.order;
import com.guanze.service.orderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet("/selectOrderServlet")
public class selectOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        String id= req.getParameter("id");
        String operation=req.getParameter("operation");
        orderService orderService_=new orderService();
        order order_=orderService_.selectById(Integer.parseInt(id));
        req.setAttribute("order",order_);
        System.out.println(order_);
        if(operation.equals("1"))
            req.getRequestDispatcher("/updateOrder.jsp").forward(req,resp);
        else if(operation.equals("2"))
            req.getRequestDispatcher("/deleteOrder.jsp").forward(req,resp);

    }
}
