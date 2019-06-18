package com.oneso.mvc.services;

import com.oneso.mvc.domain.Author;

import java.util.List;

public interface AuthorService {

    void addAuthor(String nameName);

    Author getAuthor(String id);

    List<Author> getAllAuthors();

    void deleteAuthor(String id);
}
