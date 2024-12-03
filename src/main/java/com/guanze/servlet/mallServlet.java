package com.guanze.servlet;

import com.guanze.pojo.goods;
import com.guanze.service.goodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "mallServlet", value = "/mallServlet")
public class mallServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*
       1.判断登录用户是管理员还是普通用户，以此转发至不同页面
       2.加载所有商品的信息
     */

      goodsService goodsService=new goodsService();
       List<goods> goodsList=goodsService.showlist();
        HttpSession session=req.getSession() ;
       session.setAttribute("goodsList",goodsList);
        System.out.println(session);

       req.getRequestDispatcher("/mall.jsp").forward(req,resp);
    }
}
