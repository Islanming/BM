package com.example.bm.dao;

import com.example.bm.entity.Book;

import java.util.List;

public interface BookDao {

    /**
     * 查询所有书籍
     * @param book
     * @return
     */
    public List<Book> list(Book book);


    /**
     * 添加书籍
     * @param book
     * @return
     */
    public Integer saveBook(Book book);


    /**
     * 更新书籍信息
     * @param book
     * @return
     */
    public Integer updateBook(Book book);


    /**
     * 根据ID删除书籍
     * @param id
     * @return
     */
    public Integer deleteById(Integer id);




}
