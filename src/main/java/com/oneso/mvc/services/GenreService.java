package com.oneso.mvc.services;

import com.oneso.mvc.domain.Genre;

import java.util.List;

public interface GenreService {

    void addGenre(String nameName);

    List<Genre> getAllGenres();

    Genre getGenre(String id);

    void deleteGenre(String id);
}
