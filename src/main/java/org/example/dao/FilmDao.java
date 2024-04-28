package org.example.dao;

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
@Document(indexName = "films", writeTypeHint = WriteTypeHint.DEFAULT)
public class FilmDao {

    @Id
    @Field
    private Integer id;

    @Field
    private boolean adult;

    @Field
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

    @Field
    private String title;

    @Field
    private double vote_average;

    @Field
    private int vote_count;
}
