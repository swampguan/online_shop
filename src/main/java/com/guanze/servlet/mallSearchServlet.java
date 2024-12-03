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
import java.io.PrintStream;
import java.util.List;

@WebServlet(name = "mallSearchServlet", value = "/mallSearchServlet")
public class mallSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        String goods_name=req.getParameter("name");
        String goods_id=req.getParameter("id");
        if(goods_id.equals("") && goods_name.equals("")){

            goodsService goodsService_=new goodsService();
            List<goods> goods_list=  goodsService_.selectAll();

            HttpSession session=req.getSession();
            session.setAttribute("goodsList",goods_list);
            req.getRequestDispatcher("/mall.jsp").forward(req,resp);

        }
        int id=0;
        if(!goods_id.equals("")){ id=Integer.parseInt(goods_id);}
        if(goods_name.equals("")){ goods_name=null;}

        goodsService goodsService_=new goodsService();
        List<goods> goods_list=  goodsService_.showlistBySearch(goods_name,id);
        System.out.println(goods_list);
        HttpSession session=req.getSession();
        session.setAttribute("goodsList",goods_list);
        req.getRequestDispatcher("/mall.jsp").forward(req,resp);

    }
}
