package org.example.service;

import org.example.testdto.Film;

import java.util.List;

public interface FilmService {

    List<Film> getFilms(String name);
}
