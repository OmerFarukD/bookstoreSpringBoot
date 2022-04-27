package com.qubitfaruk.bookstore.dataAccess;

import com.qubitfaruk.bookstore.entities.concrete.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
}
