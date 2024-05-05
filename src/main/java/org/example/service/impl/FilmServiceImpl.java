package org.example.service.impl;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.FilmDao;
import org.example.dto.detail.FilmDetail;
import org.example.dto.detail.Genres;
import org.example.dto.detail.ProductionCompanies;
import org.example.dto.detail.ProductionCountries;
import org.example.dto.small.FilmItem;
import org.example.dto.small.FilmItemList;
import org.example.repo.FilmRepo;
import org.example.service.FilmService;
import org.example.service.RequestService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepo filmRepo;
    private final ElasticsearchOperations elasticsearchOperations;
    private final RequestService requestService;

    @Override
    public List<FilmDao> getFilms(String name, Integer page) {

        NativeQueryBuilder builder = new NativeQueryBuilder();
        SearchHits<FilmDao> searchHits;
        NativeQuery nativeQuery;

        int totalPages;
        if(page == null){
            page = 1;
        }

        nativeQuery = builder.withQuery(q -> q.bool(bool -> {
                    bool.must(must -> {
                        if (StringUtils.isNotBlank(name)) {
                            must.match(m -> m.field("name").query(name));
                        } else {
                            must.matchAll(m -> m);
                        }
                        return must;
                    });
                    return bool;
                }))
                .withPageable(PageRequest.of(page - 1, 10))
                .build();

        searchHits =  elasticsearchOperations.search(nativeQuery, FilmDao.class);
        log.info("блаблабла");
        return searchHits.getSearchHits().stream().map(SearchHit::getContent).toList();
    }

    @Override
    public FilmDao getFilmById(Integer id) {
        Optional<FilmDao> filmDao = filmRepo.findById(id);
        return filmDao.get();
    }

    @Override
    public void addFilm(FilmDetail filmDetail) throws IOException {

        String image64 = requestService.encode(filmDetail.getPoster_path());

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

        for (int i = 1; i <= 10; i++) {
            FilmItemList filmItemList = requestService.getFilms(i);
            for (FilmItem filmItem : filmItemList.getResults()) {

                FilmDetail filmDetail = requestService.getDetailFilm(filmItem.getId());

                FilmDao filmDao = new FilmDao();

                filmDao.setId(filmDetail.getId());
                filmDao.setBudget(filmDetail.getBudget());

                List<String> gen = new ArrayList<>();
                for (Genres genre : filmDetail.getGenres()) {
                    String g = genre.getName();
                    gen.add(g);
                }
                filmDao.setGenres(gen);

                filmDao.setOriginal_title(filmDetail.getOriginal_title());
                filmDao.setOverview(filmDetail.getOverview());
                filmDao.setPopularity(filmDetail.getPopularity());

                String image64 = requestService.encode(filmDetail.getPoster_path());
                filmDao.setPoster(image64);

                List<String> companies = new ArrayList<>();
                for (ProductionCompanies productionCompany : filmDetail.getProduction_companies()) {
                    String com = productionCompany.getName();
                    companies.add(com);
                }
                filmDao.setProduction_companies(companies);

                List<String> countries = new ArrayList<>();
                for (ProductionCountries productionCountries : filmDetail.getProduction_countries()) {
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
                log.info("saved film with id {}", filmDao.getId());
            }
        }
    }
}
