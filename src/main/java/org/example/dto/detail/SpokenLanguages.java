package org.example.dto.detail;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SpokenLanguages {

    private String english_name;
    private String  iso_639_1;
    private String name;
}
