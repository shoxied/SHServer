package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.base64.Requester;
import org.example.dto.detail.Genres;
import org.example.dto.detail.ProductionCompanies;
import org.example.dto.detail.ProductionCountries;
import org.example.dao.FilmDao;
import org.example.repo.FilmRepo;
import org.example.service.FilmService;
import org.example.dto.detail.FilmDetail;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepo filmRepo;
    private final ElasticsearchOperations elasticsearchOperations;
    private final Requester requester;

    @Override
    public List<FilmDao> getFilms(String name) {

        NativeQueryBuilder builder = new NativeQueryBuilder();
        SearchHits<FilmDao> searchHits;
        NativeQuery nativeQuery;

        if (name != null){
            nativeQuery = builder.withQuery(q->q.match(m->m.field("name").query(name))).build();
        }
        else {
            nativeQuery = builder.withQuery(q->q.bool(b->b)).build();
        }

        searchHits =  elasticsearchOperations.search(nativeQuery, FilmDao.class);
        return searchHits.getSearchHits().stream().map(SearchHit::getContent).toList();
    }

    @Override
    public void addFilm(FilmDetail filmDetail) throws IOException {

        String image64 = requester.encode(filmDetail.getPoster_path());

        FilmDao filmDao = new FilmDao();

        filmDao.setId(filmDetail.getId());
        filmDao.setBudget(filmDetail.getBudget());

        List<String> gen = new ArrayList<>();
        for (Genres genre: filmDetail.getGenres()){
            String g = genre.getName();
            gen.add(g);
        }
        filmDao.setGenres(gen);

        filmDao.setOriginal_title(filmDetail.getOriginal_title());
        filmDao.setOverview(filmDetail.getOverview());
        filmDao.setPopularity(filmDetail.getPopularity());
        filmDao.setPoster(image64);

        List<String> companies = new ArrayList<>();
        for (ProductionCompanies productionCompany: filmDetail.getProduction_companies()){
            String com = productionCompany.getName();
            companies.add(com);
        }
        filmDao.setProduction_companies(companies);

        List<String> countries = new ArrayList<>();
        for (ProductionCountries productionCountries: filmDetail.getProduction_countries()){
            String com = productionCountries.getName();
            countries.add(com);
        }
        filmDao.setProduction_countries(countries);

        filmDao.setRelease_date(filmDetail.getRelease_date());
        filmDao.setRevenue(filmDetail.getRevenue());
        filmDao.setRuntime(filmDetail.getRuntime());
        filmDao.setStatus(filmDetail.getStatus());
        filmDao.setTitle(filmDetail.getTitle());
        filmDao.setVote_average(filmDetail.getVote_average());
        filmDao.setVote_count(filmDetail.getVote_count());

        filmRepo.save(filmDao);
    }

    @Override
    public void addManyFilms() throws IOException {
//
//
//
//        String image64 = requester.encode(filmDetail.getPoster_path());
//
//        FilmDao filmDao = new FilmDao();
//
//        filmDao.setId(filmDetail.getId());
//        filmDao.setBudget(filmDetail.getBudget());
//
//        List<String> gen = new ArrayList<>();
//        for (Genres genre: filmDetail.getGenres()){
//            String g = genre.getName();
//            gen.add(g);
//        }
//        filmDao.setGenres(gen);
//
//        filmDao.setOriginal_title(filmDetail.getOriginal_title());
//        filmDao.setOverview(filmDetail.getOverview());
//        filmDao.setPopularity(filmDetail.getPopularity());
//        filmDao.setPoster(image64);
//
//        List<String> companies = new ArrayList<>();
//        for (ProductionCompanies productionCompany: filmDetail.getProduction_companies()){
//            String com = productionCompany.getName();
//            companies.add(com);
//        }
//        filmDao.setProduction_companies(companies);
//
//        List<String> countries = new ArrayList<>();
//        for (ProductionCountries productionCountries: filmDetail.getProduction_countries()){
//            String com = productionCountries.getName();
//            countries.add(com);
//        }
//        filmDao.setProduction_countries(countries);
//
//        filmDao.setRelease_date(filmDetail.getRelease_date());
//        filmDao.setRevenue(filmDetail.getRevenue());
//        filmDao.setRuntime(filmDetail.getRuntime());
//        filmDao.setStatus(filmDetail.getStatus());
//        filmDao.setTitle(filmDetail.getTitle());
//        filmDao.setVote_average(filmDetail.getVote_average());
//        filmDao.setVote_count(filmDetail.getVote_count());
//
//        filmRepo.save(filmDao);
    }
}
