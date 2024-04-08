package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.FilmRepo;
import org.example.service.FilmService;
import org.example.testdto.Film;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final ElasticsearchOperations elasticsearchOperations;
    @Override
    public List<Film> getFilms(String name) {

        NativeQueryBuilder builder = new NativeQueryBuilder();
        SearchHits<Film> searchHits;
        NativeQuery nativeQuery;

        if (name != null){
            nativeQuery = builder.withQuery(q->q.match(m->m.field("name").query(name))).build();
        }
        else {
            nativeQuery = builder.withQuery(q->q.bool(b->b)).build();
        }

        searchHits =  elasticsearchOperations.search(nativeQuery, Film.class);
        return searchHits.getSearchHits().stream().map(SearchHit::getContent).toList();
    }
}
