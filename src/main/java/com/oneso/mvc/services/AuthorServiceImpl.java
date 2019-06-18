package com.oneso.mvc.services;

import com.oneso.mvc.domain.Author;
import com.oneso.mvc.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void addAuthor(String nameName) {
        Author author = new Author(nameName);
        authorRepository.save(author);
    }

    @Override
    public Author getAuthor(String id) {
        Optional<Author> author = authorRepository.findById(id);

        return author.orElseGet(Author::new);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteAuthor(String id) {
        authorRepository.deleteById(id);
    }
}
