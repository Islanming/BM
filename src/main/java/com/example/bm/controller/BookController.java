package com.example.bm.controller;

import com.example.bm.HelloServlet;
import com.example.bm.entity.Book;
import com.example.bm.service.BookService;
import com.example.bm.service.BookServiceImpl;
import com.example.bm.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "bookController",value = "/bookController")
public class BookController extends HelloServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对post提交的数据 在获取数据之前设置编码方式
        req.setCharacterEncoding("utf-8");
        //获取提交的type数据
        String type = req.getParameter("type");
        if(type!=null && !"".equals(type)){
            if(Constant.SERVLET_TYPE_SAVE.equals(type)){
                //添加用户

            }else if(Constant.SERVLET_TYPE_UPDATE.equals(type)){
                //更新用户信息
            }else if (Constant.SERVLET_TYPE_DELETE.equals(type)){
                //删除用户

            }else {
                //查询用户信息
                queryBookList(req,resp);
            }
        }else {
            queryBookList(req,resp);
        }
    }

    private void queryBookList(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //查询所有书籍
        List<Book> list = bookService.list(null);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/book.jsp").forward(request,response);
    }
}
