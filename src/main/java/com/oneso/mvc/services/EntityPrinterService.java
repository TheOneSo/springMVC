package com.oneso.mvc.services;

import com.oneso.mvc.domain.Author;
import com.oneso.mvc.domain.Book;
import com.oneso.mvc.domain.Comment;
import com.oneso.mvc.domain.Genre;

import java.util.List;

public interface EntityPrinterService {

    String preparePrintBooks(List<Book> books);

    String preparePrintAuthors(List<Author> authors);

    String preparePrintGenres(List<Genre> authors);

    String preparePrintComments(List<Comment> comments);

    String preparePrintBook(Book book);

    String preparePrintAuthorWithBook(List<Book> books);

    String preparePrintGenreWithBook(List<Book> books);
}
