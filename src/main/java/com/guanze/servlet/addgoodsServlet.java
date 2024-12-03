package com.guanze.servlet;

import com.guanze.service.goodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet("/addgoodsServlet")
public class addgoodsServlet  extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        String name = req.getParameter("name");
        String Price = req.getParameter("price");
        double price = Double.valueOf(Price);
        String Quantity = req.getParameter("quantity");
        int quantity = Integer.valueOf(Quantity);
        String description = req.getParameter("description");

        goodsService goodsService_ = new goodsService();
        int flag = goodsService_.add(name, price, description,quantity);
        if (flag != 0) {

            req.getRequestDispatcher("/mallServlet").forward(req, resp);
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.write("添加商品失败");
            writer.write(" <p><a href=\"mall.jsp\">返回商城主页</a> </p>");
        }
    }
}
