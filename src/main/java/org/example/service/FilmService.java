package org.example.service;

import org.example.dao.FilmFavorite;
import org.example.dto.detail.FilmDetail;
import org.example.dao.FilmDao;

import java.io.IOException;
import java.util.List;

public interface FilmService {
    List<FilmDao> getFilms(String name, Integer page);

    FilmDao getFilmById(Integer id);

    void addFilm(FilmDetail filmDetail) throws IOException;

    void addManyFilms() throws IOException;

    void addToFavorite(Integer id);

    void deleteFromFavorite(Integer id);

    List<FilmFavorite> getFavoriteFilms();
}
