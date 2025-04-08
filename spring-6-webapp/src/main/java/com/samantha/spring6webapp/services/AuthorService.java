package com.samantha.spring6webapp.services;

import com.samantha.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
