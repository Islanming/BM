package com.example.bm.dao;





import com.example.bm.entity.User;
import com.example.bm.util.DelFlagE;
import com.example.bm.util.MyDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
public class UserDaoImpl implements UserDao{
    @Override
    public List<User> list(User user){
        //获取QueryRunner
        QueryRunner queryRunner = MyDBUtils.getQueryRunner();
        //构建SQL语句
        String sql = "select * from user where is_delete = ?";
        List<User> list = new ArrayList<>();
        try {
            list = queryRunner.query(sql, new ResultSetHandler<List<User>>() {
                @Override
                public List<User> handle(ResultSet resultSet) throws SQLException {
                    List<User> list = new ArrayList<>();
                    while (resultSet.next()){
                        User u = setUser(resultSet);
                        String role = "读者";
                        if (role.equals(u.getRole())){
                            u.setArea("");
                        }else {
                            u.setArea(resultSet.getString("area"));
                        }
                        list.add(u);
                    }
                    return list;
                }
            },DelFlagE.NO.code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    private User setUser(ResultSet resultSet) throws SQLException {
        User u = new User();
        u.setUname(resultSet.getString("uname"));
        u.setPwd(resultSet.getString("pwd"));
        u.setName(resultSet.getString("name"));
        u.setUid(resultSet.getInt("id"));
        u.setPhoneNumber(resultSet.getString("phoneNumber"));
        u.setEmil(resultSet.getString("emil"));
        u.setSex(resultSet.getString("sex"));
        u.setRole(resultSet.getString( "role"));

        return u;
    }


    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public Integer save(User user){
        QueryRunner queryRunner = MyDBUtils.getQueryRunner();
        String sql = "insert into user(uname,pwd,name,sex,role,phoneNumber,emil,area)value(?,?,?,?,?,?,?,?)";
        try {
            return queryRunner.update(sql,user.getUname()
                    ,user.getPwd()
                    ,user.getName()
                    ,user.getSex()
                    ,user.getRole()
                    ,user.getPhoneNumber()
                    ,user.getEmil()
                    ,user.getArea()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public Integer deleteById(Integer id){
        QueryRunner queryRunner = MyDBUtils.getQueryRunner();
//        String sql = "delete from user where id = ? ";
        //逻辑删除
        String sql = "update user set is_delete = ? where id = ?";
        try {
            return queryRunner.update(sql, DelFlagE.YES,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public User queryById(Integer id) {
        QueryRunner queryRunner = MyDBUtils.getQueryRunner();
        String sql = "select * from user where id = ? ";
        try {
            return queryRunner.query(sql, new ResultSetHandler<User>() {
                @Override
                public User handle(ResultSet resultSet) throws SQLException {
                    if(resultSet.next()){
                        User u = setUser(resultSet);
                        return u;
                    }
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public User login(String uname, String pwd){
        QueryRunner queryRunner = MyDBUtils.getQueryRunner();
        String sql = "select * from user where uname='"+uname+"'and pwd = '"+pwd+"'";
        try {
            return queryRunner.query(sql, new ResultSetHandler<User>() {
                @Override
                public User handle(ResultSet resultSet) throws SQLException {
                    if(resultSet.next()){
                        return setUser(resultSet);
                    }
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
