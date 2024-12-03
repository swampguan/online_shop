package com.guanze.servlet;

import com.guanze.pojo.order;
import com.guanze.pojo.user;
import com.guanze.service.orderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

@WebServlet(name = "orderServlet", value = "/orderServlet")
public class orderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        orderService orderService_=new orderService();
        HttpSession session=req.getSession() ;
        user user_=(user) session.getAttribute("user");
        System.out.println(user_.getUser_id());
        List<order> orderList=orderService_.showlist(user_.getUser_id());

        session.setAttribute("orderList",orderList);
        double totalprice=0;
        for(int i=0;i<orderList.size();i++)
        {
            totalprice=totalprice+orderList.get(i).getPrice()*orderList.get(i).getQuantity();
            System.out.println(orderList.get(i));
        }
        session.setAttribute("totalprice",totalprice);
        req.getRequestDispatcher("/order.jsp").forward(req,resp);
    }
}
