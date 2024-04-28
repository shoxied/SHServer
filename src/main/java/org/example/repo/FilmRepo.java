package org.example.repo;

import org.example.dao.FilmDao;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepo extends ElasticsearchRepository<FilmDao, Integer> { }
