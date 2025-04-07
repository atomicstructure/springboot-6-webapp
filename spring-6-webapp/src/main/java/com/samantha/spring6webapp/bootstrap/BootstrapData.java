package com.samantha.spring6webapp.bootstrap;

import com.samantha.spring6webapp.domain.Author;
import com.samantha.spring6webapp.domain.Book;
import com.samantha.spring6webapp.repositories.AuthorRepository;
import com.samantha.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Author femi = new Author();
        femi.setFirstName("Femi");
        femi.setLastName("Ogunyemi");

        Author mary = new Author();
        mary.setFirstName("Mary");
        mary.setLastName("Ogundare");

        Book book1 = new Book();
        book1.setTitle("Spring in Action");
        book1.setIsbn("123456789");

        Book book2 = new Book();
        book2.setTitle("In My House");
        book2.setIsbn("453628372A1");

        Author femiSaved = authorRepository.save(femi);
        Book bookSaved = bookRepository.save(book1);

        Author marySaved = authorRepository.save(mary);
        Book book2Saved = bookRepository.save(book2);

        femiSaved.getBooks().add(bookSaved);
        marySaved.getBooks().add(book2Saved);

        authorRepository.save(femiSaved);
        authorRepository.save(marySaved);

        System.out.println("Started in Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
