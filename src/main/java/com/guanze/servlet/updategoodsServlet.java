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

@WebServlet(name = "updategoodsServlet", value = "/updategoodsServlet")
public class updategoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        
        String name= req.getParameter("name");
        String id=req.getParameter("id");
        String Price=req.getParameter("price");
        String description=req.getParameter("description");
        double price=Double.valueOf(Price);
        goods goods_=new goods();
        goods_.setGoods_id(Integer.parseInt(id));
        goods_.setGoods_name(name);
        goods_.setPrice(price);
        goods_.setDescription(description);
        goodsService goodsService=new goodsService();

        int flag=goodsService.update(goods_);
        if(flag==1)
        {
            req.getRequestDispatcher("/mallServlet").forward(req,resp);}
        else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer=resp.getWriter();
            writer.write("商品修改失败");
            writer.write(" <p><a href=\"mall.jsp\">返回商城主页</a> </p>");
        }
    }
}
