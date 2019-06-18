package com.oneso.mvc.services;

import com.oneso.mvc.domain.Author;
import com.oneso.mvc.domain.Book;
import com.oneso.mvc.domain.Genre;
import com.oneso.mvc.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(String bookName, String authorName, String genreName) {
        Book book = new Book(bookName, new Author(authorName), new Genre(genreName));
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(String id) {
        return bookRepository.findById(id).orElseGet(Book::new);
    }

    @Override
    public List<Book> getAllBookByAuthorName(String name) {
        return bookRepository.findBookByAuthorName(name);
    }

    @Override
    public List<Book> getAllBookByAuthorId(String id) {
        return bookRepository.findBookByAuthorId(id);
    }

    @Override
    public List<Book> getAllBookByGenreName(String name) {
        return bookRepository.findBookByGenreName(name);
    }

    @Override
    public List<Book> getAllBookByGenreId(String id) {
        return bookRepository.findBookByGenreId(id);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteBookByAuthor(String id) {
        bookRepository.deleteBookByAuthorId(id);
    }
}
