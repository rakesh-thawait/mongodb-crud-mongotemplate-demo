package com.rt.mongodb.repository;

import com.rt.mongodb.domain.Book;

import java.util.List;

public interface BookDAL {

    public List<Book> getAllBook();

    public Book findById(String id);

    public Book save(Book book);

    public Book update(Book book);

    public void delete(String id);
}
