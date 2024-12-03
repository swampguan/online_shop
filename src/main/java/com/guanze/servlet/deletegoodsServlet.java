package com.guanze.servlet;

import com.guanze.pojo.goods;
import com.guanze.service.goodsService;
import com.guanze.service.orderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet(name = "deletegoodsServlet", value = "/deletegoodsServlet")
public class deletegoodsServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        String id=req.getParameter("id");
        goods goods_=new goods();
        goods_.setGoods_id(Integer.parseInt(id));
        goodsService goodsService_=new goodsService();
        orderService orderService_=new orderService();
        int flag2=orderService_.del_none_goods(goods_);
        int flag=goodsService_.delete(goods_);
        if(flag==1 && flag2==1)
        {
            req.getRequestDispatcher("/mallServlet").forward(req,resp);}
        else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer=resp.getWriter();
            writer.write("删除出现错误！");
            writer.write(" <p><a href=\"login.jsp\">返回商城</a></p>");
        }

    }
}
