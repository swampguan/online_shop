package com.guanze.servlet;

import com.guanze.pojo.order;
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

@WebServlet(name = "historyServlet", value = "/historyServlet")
public class historyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        String operation = req.getParameter("operation");
        orderService orderService = new orderService();
        if (operation.equals("1")) {
            List<order> orderhistory = orderService.showhistory();
            HttpSession session = req.getSession();
            session.setAttribute("orderhistory", orderhistory);
            System.out.println(orderhistory);
            req.getRequestDispatcher("/history.jsp").forward(req, resp);
        }
        if (operation.equals("2")) {
            String usersid = req.getParameter("usersid");
            List<order> orderhistory = orderService.showuserhistory(Integer.parseInt(usersid));
            HttpSession session = req.getSession();
            session.setAttribute("orderhistory", orderhistory);
            System.out.println(orderhistory);
            req.getRequestDispatcher("/history_users.jsp").forward(req, resp);
        }
        if (operation.equals("3")) {

            List<order> orderhistory = orderService.showgoodhistory();
            HttpSession session = req.getSession();
            session.setAttribute("orderhistory", orderhistory);

            req.getRequestDispatcher("/history_goods.jsp").forward(req, resp);
        }
    }
}
