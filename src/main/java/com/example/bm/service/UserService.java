package com.example.bm.service;



import com.example.bm.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lenovo
 */
public interface UserService {
    /**
     * 根据User对象封装的条件来查询用户信息
     * @param user
     * @return
     */
    public List<User> queryUser(User user) throws SQLException;

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public Integer saveUser(User user);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    public Integer deleteById(Integer id);


    /**
     * 登录
     * @param uname
     * @param pwd
     * @return
     */
    public User login(String uname,String pwd);

}
