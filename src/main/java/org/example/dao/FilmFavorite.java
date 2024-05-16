package org.example.dao;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(indexName = "favorite-films", writeTypeHint = WriteTypeHint.DEFAULT)
public class FilmFavorite {

    @Id
    @Field(name = "id", type = FieldType.Integer)
    private Integer id;

    @Field(name = "adult", type = FieldType.Keyword)
    private boolean adult;

    @Field(name = "budget", type = FieldType.Keyword)
    private long budget;

    @Field
    private List<String> genres;

    @Field
    private String original_title;

    @Field
    private String overview;

    @Field
    private double popularity;

    @Field
    private String poster;

    @Field
    private List<String> production_companies;

    @Field
    private List<String> production_countries;

    @Field
    private String release_date;

    @Field
    private int revenue;

    @Field
    private int runtime;

    @Field
    private String status;

    @Field(name = "title", type = FieldType.Text, analyzer = "en-ru")
    private String title;

    @Field
    private double vote_average;

    @Field
    private int vote_count;
}
