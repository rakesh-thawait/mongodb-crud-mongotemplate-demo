package com.rt.mongodb.rest;

import com.rt.mongodb.domain.Book;
import com.rt.mongodb.repository.BookDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    BookDAL bookRepo;

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        Book savedBook = bookRepo.save(book);
        return ResponseEntity.ok(savedBook);
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book) {
        if (book.getId() == null) {
            bookRepo.save(book);
        } else {
            if (bookRepo.findById(book.getId()) != null) {
                bookRepo.save(book);
            } else {
                book.setId(null);
                bookRepo.save(book);
            }
        }

        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> books = bookRepo.getAllBook();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        return Optional.ofNullable( bookRepo.findById(id) )
                .map( book -> ResponseEntity.ok(book))
                .orElseGet( () -> ResponseEntity.notFound().build() );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> save(@PathVariable String id) {
        bookRepo.delete(id);
        return ResponseEntity.ok().build();
    }
}
