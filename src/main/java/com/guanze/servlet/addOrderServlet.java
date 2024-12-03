package com.guanze.servlet;

import com.guanze.service.orderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet(name = "addOrderServlet", value = "/addOrderServlet")
public class addOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        String Usersid=req.getParameter("user_id");
        String Goodsid=req.getParameter("goods_id");
        String goodsname=req.getParameter("goods_name");
        String Price=req.getParameter("price");
        String Quantity=req.getParameter("quantity");

        double price=Double.valueOf(Price);
        int usersid=Integer.parseInt(Usersid);
        int goodsid=Integer.parseInt(Goodsid);
        int quantity=Integer.parseInt(Quantity);
        orderService orderService_=new orderService();
        orderService_.add(usersid,goodsid,quantity,price,goodsname);
        req.getRequestDispatcher("/mallServlet").forward(req,resp);

    }
}
