package org.example;


import org.example.service.impl.FilmServiceImpl;
import org.example.testdto.Film;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
        FilmController.class,
        FilmServiceImpl.class,
})
@EnableElasticsearchRepositories(basePackageClasses = {Film.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}