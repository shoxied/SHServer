package org.example;

import lombok.RequiredArgsConstructor;
import org.example.service.FilmService;
import org.example.testdto.Film;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dada")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping(value = "films",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> films(@RequestParam(name = "name", required = false) String name){
        return filmService.getFilms(name);
    }
}
