package com.guanze.servlet;

import com.guanze.pojo.goods;
import com.guanze.service.goodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet(name = "selectIdServlet", value = "/selectIdServlet")
public class selectIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        String id = req.getParameter("id");
        String operation = req.getParameter("operation");
        goodsService goodsService_ = new goodsService();
        goods goods_ = goodsService_.selectbyid(Integer.parseInt(id));
        req.setAttribute("goods", goods_);
        System.out.println(goods_);
        if (operation.equals("1"))
            req.getRequestDispatcher("/update_goods.jsp").forward(req, resp);
        else if (operation.equals("2"))
            req.getRequestDispatcher("/delete_goods.jsp").forward(req, resp);
        else if (operation.equals("3"))
            req.getRequestDispatcher("/add_order.jsp").forward(req, resp);
    }
}
