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
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Lenovo
 */
@WebServlet(name = "userController",value = "/userController")
public class UserController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //对post提交的数据 在获取数据之前设置编码方式
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        //获取type参数
        String type = req.getParameter("type");
        System.out.println("type="+type+"id="+id);
        if(type!=null && !"".equals(type)){
            if(Constant.SERVLET_TYPE_SAVE.equals(type)){
                //添加用户
                addUser(req,resp);
            }else if(Constant.SERVLET_TYPE_UPDATE.equals(type)){
                //更新用户信息
            }else if (Constant.SERVLET_TYPE_DELETE.equals(type)){
                //删除用户
                deleteUserById(req,resp);
            }else {
                //查询用户信息
                queryUser(req,resp);
            }
        }else {
            queryUser(req,resp);
        }
    }


    /**
     * 查询用户信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //查询所有用户信息
        List<User> list = null;
        try {
            list = userService.queryUser(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //查询的数据存在Request作用域中
        req.setAttribute("list",list);
        //跳转到JSP页面
        req.getRequestDispatcher("/user.jsp").forward(req,resp);

    }

    /**
     * 添加用户
     * @param req
     * @param resp
     * @throws IOException
     */
    protected void addUser(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        //添加用户信息
        User u = new User();
        u.setUname(req.getParameter("uname"));
        u.setPwd(req.getParameter("pwd"));
        u.setName(req.getParameter("name"));
//        u.setUid(Integer.parseInt(req.getParameter("id")));
        u.setPhoneNumber(req.getParameter("phoneNumber"));
        u.setEmil(req.getParameter("emil"));
        u.setSex(req.getParameter("sex"));
        u.setRole(req.getParameter( "role"));
        u.setArea(req.getParameter("area"));
        //count返回的影响行数，大于0则表成功
        Integer count = userService.saveUser(u);
        if(count>0){
            //成功，查询所有用户信息，重定向
            resp.sendRedirect("/userController");
        }else {
            //失败
            System.out.println("添加用户失败");
        }

    }

    /**
     *删除用户
     * @param req
     * @param resp
     * @throws IOException
     */

    protected void deleteUserById(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        //获取需删用户Id
        String id = req.getParameter("id");
        //通过Service进行删除操作
        Integer count = userService.deleteById(Integer.parseInt(id));

        //重定向，回到用户列表界面
        resp.sendRedirect("/userController");


    }




}
