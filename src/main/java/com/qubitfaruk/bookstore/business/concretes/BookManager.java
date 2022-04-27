package com.qubitfaruk.bookstore.business.concretes;

import com.qubitfaruk.bookstore.business.abstracts.IBookService;
import com.qubitfaruk.bookstore.dataAccess.IBookRepository;
import com.qubitfaruk.bookstore.entities.concrete.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
       return this.bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }
}
