package com.oneso.mvc.repository;

import com.oneso.mvc.domain.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Optional<Author> findAuthorByName(String name);

    void deleteAuthorByName(String name);
}
