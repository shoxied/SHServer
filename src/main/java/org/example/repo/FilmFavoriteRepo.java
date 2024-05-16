package org.example.repo;

import org.example.dao.FilmFavorite;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmFavoriteRepo extends ElasticsearchRepository<FilmFavorite, Integer> { }
