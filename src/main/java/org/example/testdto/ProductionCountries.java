package org.example.testdto;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductionCountries {

    @Field
    private String iso_3166_1;

    @Field
    private String name;
}
