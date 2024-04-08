package org.example.testdto;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductionCompanies {

    @Field
    private int id;

    @Field
    private String logo_path;

    @Field
    private String name;

    @Field
    private String origin_country;
}
