package org.example.dto.small;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class FilmItemList {
    private Integer page;
    private List<FilmItem> results;
    private Long total_pages;
    private Long total_results;
}
