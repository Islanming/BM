package com.example.bm.dao;



import com.example.bm.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
     /**
     * 查询用户信息
     * @param user 可能带有的查询条件
     * @return
     */
     public List<User> list(User user) throws SQLException;

     /**
      * 添加用户信息
      * @param user
      * @return
      */
     public Integer save(User user);

     /**
      * 删除用户信息
      * @param id
      * @return
      */
     public Integer deleteById(Integer id);

     /**
      * 修改用户信息
      * @param id
      * @return
      */
      public User queryById(Integer id);

     /**
      * 登录验证
      * @param uname
      * @param pwd
      * @return
      */
     public User login(String uname,String pwd);



}
