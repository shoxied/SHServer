package org.example.dto;

import org.example.testdto.Film;
import org.springframework.data.repository.CrudRepository;

public interface TestFilmRepo extends CrudRepository<Film, Integer> {
}
