package org.example.service;

import org.example.dto.detail.FilmDetail;
import org.example.dao.FilmDao;

import java.io.IOException;
import java.util.List;

public interface FilmService {
    List<FilmDao> getFilms(String name);

    void addFilm(FilmDetail filmDetail) throws IOException;

    void addManyFilms() throws IOException;
}
