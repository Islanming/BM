package com.example.bm.dao;

import com.example.bm.entity.Book;
import com.example.bm.util.DelFlagE;
import com.example.bm.util.MyDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookDaoImpl implements BookDao{

    String sql;
    QueryRunner queryRunner;

//    public static void main(String[] args) {
//        BookDaoImpl dao = new BookDaoImpl();
//        Book book = new Book();
//        book.setId(1);
//        book.setName("时间简史");
//        book.setWriter("霍金");
//        book.setPrice(new BigDecimal(59.9));
//        book.setIsbn("xxx0102123231");
//        book.setType("科普类");
//        book.setLnumber(32);
//        //dao.saveBook(book);
//        dao.updateBook(book);
//        List<Book> list = dao.list(null);
//        System.out.println(list);
//        }

    @Override
    public List<Book> list(Book book) {
        queryRunner = MyDBUtils.getQueryRunner();
        sql = "select * from book where is_delete = 1";
        List<Book> list = new ArrayList<>();
        try {
            list= queryRunner.query(sql, new ResultSetHandler<List<Book>>() {
                @Override
                public List<Book> handle(ResultSet resultSet) throws SQLException {
                    List<Book> list = new ArrayList<>();
                    while (resultSet.next()){
                        Book b = new Book();
                        b.setId(resultSet.getInt("id"));
                        b.setIsbn(resultSet.getString("ISBN"));
                        b.setName(resultSet.getString("name"));
                        b.setPrice(resultSet.getBigDecimal("price"));
                        b.setLnumber(resultSet.getInt("lnumber"));
                        b.setType(resultSet.getString("type"));
                        b.setWriter(resultSet.getString("writer"));
                        b.setIsDelete(resultSet.getInt("is_delete"));
                        list.add(b);
                    }
                    return list;
                }
            },DelFlagE.NO.code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Integer saveBook(Book book) {
        queryRunner = MyDBUtils.getQueryRunner();
        sql = "insert into book(name,writer,type,ISBN,price,lnumber)values(?,?,?,?,?,?)";
        try {
            return queryRunner.update(sql,book.getName(),
                    book.getWriter(),
                    book.getType(),
                    book.getIsbn(),
                    book.getPrice(),
                    book.getLnumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer updateBook(Book book) {
        queryRunner = MyDBUtils.getQueryRunner();
        if(book.getIsDelete()==null || "".equals(book.getIsDelete())){
            book.setIsDelete(DelFlagE.NO.code);
        }
        sql = "update book set name = ?,writer = ?,type = ?,ISBN = ?,price = ?,lnumber = ?,is_delete=? where id = ?";
        try {
            return queryRunner.update(sql, book.getName(),
                    book.getWriter(),
                    book.getType(),
                    book.getIsbn(),
                    book.getPrice(),
                    book.getLnumber(),
                    book.getIsDelete(),
                    book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer deleteById(Integer id) {
        queryRunner = MyDBUtils.getQueryRunner();
        sql = "update book set is_delete = ? where id = ?";
        try {
            return queryRunner.update(sql,DelFlagE.YES.code,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }








}
