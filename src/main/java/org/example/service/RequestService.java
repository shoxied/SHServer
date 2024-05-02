package org.example.service;

import org.example.dao.FilmDao;
import org.example.dto.detail.FilmDetail;
import org.example.dto.small.FilmItem;
import org.example.dto.small.FilmItemList;

import java.io.IOException;
import java.util.List;

public interface RequestService {

    String encode(String urlImage) throws IOException;

    FilmItemList getFilms(Integer page);

    FilmDetail getDetailFilm(Integer id);
}
