package com.oneso.mvc.repository;

import com.oneso.mvc.domain.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, String> {

    Optional<Genre> findGenreByName(String name);

    void deleteGenreByName(String name);
}
