package com.guanze.servlet;

import com.guanze.pojo.order;
import com.guanze.service.goodsService;
import com.guanze.service.orderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet (name = "purchaseServlet", value = "/purchaseServlet")
public class purchaseServlet  extends HttpServlet {
    String operation=null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));


        operation=req.getParameter("operation");
        System.out.println("结算中");
        HttpSession session=req.getSession();

        orderService orderService_=new orderService();
        goodsService goodsService_=new goodsService();
        List<order> orderList=(List<order>) session.getAttribute("orderList");

        for (int i=0;i<orderList.size();i++)
        {
            orderService_.purchase(orderList.get(i));
            goodsService_.updateGQ(orderList.get(i).getGoods_id(), orderList.get(i).getQuantity());
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        writer.write("<h1>购买成功<h1><br>");
        writer.write("  <a href=\"mall.jsp\">返回商城首页</a> </p>");
    }
}
