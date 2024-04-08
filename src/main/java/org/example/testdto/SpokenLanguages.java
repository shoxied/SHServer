package org.example.testdto;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SpokenLanguages {

    @Field
    private String english_name;

    @Field
    private String  iso_639_1;

    @Field
    private String name;
}
