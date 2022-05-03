package com.qubitfaruk.bookstore.api.controller;

import com.qubitfaruk.bookstore.business.abstracts.IBookService;
import com.qubitfaruk.bookstore.entities.concrete.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @PostMapping("/addBook") // http://localhost:8080/api/books/addBook
    public ResponseEntity<?> addBook(@RequestBody Book book){
        return new ResponseEntity<>(this.bookService.saveBook(book), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        this.bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBook(){
        return new ResponseEntity<>(this.bookService.findAll(),HttpStatus.OK);
    }
}
