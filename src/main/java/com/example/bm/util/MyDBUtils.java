package com.example.bm.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @author Lenovo
 */
public class MyDBUtils {

    private  static MysqlDataSource dataSource;

    static {
        dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bookbd?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
    }

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }

}
