package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dao.FilmDao;
import org.example.service.impl.FilmServiceImpl;
import org.example.dto.detail.FilmDetail;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/dada")
@RequiredArgsConstructor
public class FilmController {

    private final FilmServiceImpl filmService;
    @GetMapping(value = "films",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmDao> films(@RequestParam(name = "name", required = false) String name){
        return filmService.getFilms(name);
    }

    @PostMapping(value = "addFilm", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFilm(@RequestBody FilmDetail filmDetail) throws IOException {
        filmService.addFilm(filmDetail);
    }

    @GetMapping(value = "addFilms", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFilm() throws IOException {
        filmService.addManyFilms();
    }
}
