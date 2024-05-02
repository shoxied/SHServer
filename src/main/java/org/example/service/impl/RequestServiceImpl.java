package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.FilmDao;
import org.example.dto.detail.FilmDetail;
import org.example.dto.small.FilmItem;
import org.example.dto.small.FilmItemList;
import org.example.service.RequestService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    @Override
    public String encode(String urlImage) throws IOException {

        String urlS = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + urlImage;
        URL url = new URL(urlS);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        log.info("base64 encode request code {}", responseCode);

        BufferedImage image = ImageIO.read(url);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        byte[] imageBytes = baos.toByteArray();

        return Base64.getEncoder().encodeToString(imageBytes);
    }

    @Override
    public FilmItemList getFilms(Integer page) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=d54b063b83bfa247f2ef350acafee7c3&language=ru&page=" + page;
        FilmItemList filmItemList = restTemplate.getForObject(url, FilmItemList.class);
        log.info("get films from page {}", page);
        return filmItemList;
    }

    @Override
    public FilmDetail getDetailFilm(Integer id) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=d54b063b83bfa247f2ef350acafee7c3&language=ru";
        FilmDetail filmDao = restTemplate.getForObject(url, FilmDetail.class);
        log.info("get film with id {}", id);
        return filmDao;
    }
}
