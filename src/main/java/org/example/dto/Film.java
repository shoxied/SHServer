package org.example.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(indexName = "detail", writeTypeHint = WriteTypeHint.DEFAULT)
public class Film {

    @Field
    private boolean adult;

    @Field
    private String backdropBase64;

    @Field
    private long budget;

    @Field
    private List<Genres> genres;

    @Id
    @Field
    private Long id;

    @Field
    private String originalLanguage;

    @Field
    private String originalTitle;

    @Field
    private String overview;

    @Field
    private double popularity;

    @Field
    private String posterBase64;

    @Field
    private List<ProductionCompanies> productionCompanies;

    @Field
    private List<ProductionCountries> productionCountries;

    @Field
    private String releaseDate;

    @Field
    private int revenue;

    @Field
    private int runtime;

    @Field
    private List<SpokenLanguages> spokenLanguages;

    @Field
    private String status;

    @Field
    private String tagline;

    @Field
    private String title;

    @Field
    private boolean video;

    @Field
    private double voteAverage;

    @Field
    private int voteCount;
}
