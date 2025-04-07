package com.samantha.spring6webapp.bootstrap;

import com.samantha.spring6webapp.domain.Author;
import com.samantha.spring6webapp.domain.Book;
import com.samantha.spring6webapp.domain.Publisher;
import com.samantha.spring6webapp.repositories.AuthorRepository;
import com.samantha.spring6webapp.repositories.BookRepository;
import com.samantha.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Publisher One");
        publisher.setAddress("123 Main St");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setZip("10001");


        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Publisher Two");
        publisher1.setAddress("456 Elm St");
        publisher1.setCity("Los Angeles");
        publisher1.setState("CA");
        publisher1.setZip("90001");


        Author femiSaved = authorRepository.save(femi);
        Book bookSaved = bookRepository.save(book1);
        Publisher publisherSaved = publisherRepository.save(publisher);

        Author marySaved = authorRepository.save(mary);
        Book book2Saved = bookRepository.save(book2);
        Publisher publisher1Saved = publisherRepository.save(publisher1);


        femiSaved.getBooks().add(bookSaved);
        marySaved.getBooks().add(book2Saved);
        bookSaved.getAuthors().add(femiSaved);


        authorRepository.save(femiSaved);
        authorRepository.save(marySaved);
        publisherRepository.save(publisherSaved);
        publisherRepository.save(publisher1Saved);

        System.out.println("Started in Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
