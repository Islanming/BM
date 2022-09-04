//package com.example.bm.controller;
//
//import com.example.bm.util.Constant;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//
//
///**
// * @author Lenovo
// */
//@WebFilter(filterName = "authenticationFilter",urlPatterns = "/*")
//public class AuthenticationFilter implements Filter {
//    @Override
//   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//       HttpServletRequest request = (HttpServletRequest) servletRequest;
//       HttpServletResponse response = (HttpServletResponse) servletResponse;
//       //获取请求地址
//       String requestURL = request.getRequestURI();
//       if(requestURL.contains("login.jsp")||requestURL.contains("loginController")){
//           //直接访问登录界面
//           filterChain.doFilter(servletRequest,servletResponse);
//       }else {
//           //判断是否是登录状态
//           HttpSession session = request.getSession();
//           Object attribute = session.getAttribute(Constant.SERVLET_TYPE_USER);
//           if(attribute!=null){
//               //已登录，放
//               filterChain.doFilter(servletRequest,servletResponse);
//           }else {
//               //未登录，跳转回登录界面
//               session.setAttribute("msg","请先登录");
//               response.sendRedirect("/login.jsp");
//           }
//       }
//
//
//   }
//
//}
