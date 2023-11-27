package com.rt.mongodb.repository;

import com.rt.mongodb.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDALImpl implements BookDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Book> getAllBook() {
        return mongoTemplate.findAll(Book.class);
    }

    @Override
    public Book findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Book.class);
    }

    @Override
    public Book save(Book book) {
        // save() saves the document if Id is not passed. If id is passed then it performs update operation
        return mongoTemplate.save(book, "book");
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Book.class);
    }
}
