package com.qubitfaruk.bookstore.business.abstracts;


import com.qubitfaruk.bookstore.dataAccess.IBookRepository;
import com.qubitfaruk.bookstore.entities.concrete.Book;

import java.util.List;

public interface IBookService {
 List<Book> findAll();
 Book saveBook(Book book);
 void deleteBook(Long id);
}
