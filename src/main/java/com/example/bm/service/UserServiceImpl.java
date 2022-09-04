package com.example.bm.service;


import com.example.bm.dao.UserDao;
import com.example.bm.dao.UserDaoImpl;
import com.example.bm.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> queryUser(User user) throws SQLException {
        return userDao.list(user);
    }

    @Override
    public Integer saveUser(User user){
        return userDao.save(user);
    }

    @Override
    public Integer deleteById(Integer id){
        return userDao.deleteById(id);
    }

    @Override
    public User login(String uname, String pwd){
        return userDao.login(uname,pwd);
    }

}
