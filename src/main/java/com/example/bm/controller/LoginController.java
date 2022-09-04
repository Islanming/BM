package com.example.bm.controller;

import com.example.bm.entity.User;
import com.example.bm.service.UserService;
import com.example.bm.service.UserServiceImpl;
import com.example.bm.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "loginController",value = "/loginController")
public class LoginController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        User user = userService.login(uname,pwd);
        HttpSession session = req.getSession();
        if(user!=null){
            user.setPwd(null);
            session.setAttribute(Constant.SERVLET_TYPE_USER,user);
            resp.sendRedirect("/main.jsp");
        }else {
            session.setAttribute("msg","账号或密码错误");
            resp.sendRedirect("/login.jsp");
        }
    }
}
