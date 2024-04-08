package org.example.testdto;

import lombok.*;
import org.example.dto.ProductionCountries;
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
@Document(indexName = "detail_catalog", writeTypeHint = WriteTypeHint.DEFAULT)
public class Film {

    @Field
    private boolean adult;

    @Field
    private String backdrop_path;

    @Field
    private List<BelongsToCollection> belongs_to_collection;

    @Field
    private long budget;

    @Field
    private List<Genres> genres;

    @Field
    private String  homepage;

    @Id
    @Field
    private int id;

    @Field
    private String imdb_id;

    @Field
    private String original_language;

    @Field
    private String original_title;

    @Field
    private String overview;

    @Field
    private double popularity;

    @Field
    private String poster_path;

    @Field
    private List<ProductionCompanies> production_companies;

    @Field
    private List<org.example.testdto.ProductionCountries> production_countries;

    @Field
    private String release_date;

    @Field
    private int revenue;

    @Field
    private int runtime;

    @Field
    private List<SpokenLanguages> spoken_languages;

    @Field
    private String status;

    @Field
    private String tagline;

    @Field
    private String title;

    @Field
    private boolean video;

    @Field
    private double vote_average;

    @Field
    private int vote_count;
}
