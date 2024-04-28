package org.example.base64;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.small.FilmItem;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Slf4j
@Component
public class Requester {

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

    public List<FilmItem> getFilms(Integer page) throws IOException{
        List<FilmItem> filmItemList = new ArrayList<>();

        String urlS = "https://api.themoviedb.org/3/movie/popular?api_key=d54b063b83bfa247f2ef350acafee7c3&language=ru&page=" + page;
        URL url = new URL(urlS);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        log.info("base64 encode request code {}", responseCode);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.readLine();

        return filmItemList;
    }
}
