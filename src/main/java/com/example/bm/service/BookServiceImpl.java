package com.example.bm.service;

import com.example.bm.dao.BookDao;
import com.example.bm.dao.BookDaoImpl;
import com.example.bm.entity.Book;

import java.util.List;

public class BookServiceImpl implements BookService{

    private BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> list(Book book) {
        return bookDao.list(book);
    }

    @Override
    public Integer saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    @Override
    public Integer updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Integer deleteById(Integer id) {
        return bookDao.deleteById(id);
    }
}
