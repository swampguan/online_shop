package com.guanze.servlet;

import com.guanze.service.orderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet(name = "updateOrderServlet", value = "/updateOrderServlet")
public class updateOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        String Id=req.getParameter("id");
        String Quantity=req.getParameter("quantity");
        int quantity=0;
        if(Quantity.equals(""))
        {quantity=0;}
        else {quantity=Integer.parseInt(Quantity);}
        int id=Integer.parseInt(Id);
       orderService orderService_=new orderService();
        orderService_.updateOrder(id,quantity);
        req.getRequestDispatcher("/orderServlet").forward(req,resp);
    }
}
