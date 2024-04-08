package org.example;

import org.example.dto.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepo extends CrudRepository<Film, Long> {
}
