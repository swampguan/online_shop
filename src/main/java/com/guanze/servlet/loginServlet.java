package com.guanze.servlet;

import com.guanze.mapper.GoodsMapper;
import com.guanze.mapper.UserMapper;
import com.guanze.pojo.goods;
import com.guanze.pojo.user;
import com.guanze.service.userService;
import com.guanze.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        String name = req.getParameter("username");

        String password = req.getParameter("password");

        userService userService_ = new userService();
        user users =  userService_.login(name, password);
        System.out.println(users);



        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (users != null) {
            writer.write("login success");
            HttpSession session = req.getSession();
            session.setAttribute("user", users);
            user temp = (user) session.getAttribute("user");

            req.getRequestDispatcher("/mallServlet").forward(req, resp);
        } else {
            writer.write("login failed");
            writer.write(" <p>back to  <a href=\"login.jsp\">Login</a> now!</p>");
        }
    }
}
