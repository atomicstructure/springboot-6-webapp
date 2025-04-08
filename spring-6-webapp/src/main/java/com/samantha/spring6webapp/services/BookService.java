package com.samantha.spring6webapp.services;

import com.samantha.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
