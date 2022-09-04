package com.example.bm.entity;

import java.math.BigDecimal;

public class Book {
    private int id;
    public String name;
    public String type;
    public String isbn;
    public String writer;
    //剩余数目
    public int lnumber;
    public BigDecimal price;
    public Integer isDelete;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isbn='" + isbn + '\'' +
                ", writer='" + writer + '\'' +
                ", lnumber=" + lnumber +
                ", price=" + price +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getLnumber() {
        return lnumber;
    }

    public void setLnumber(int lnumber) {
        this.lnumber = lnumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
