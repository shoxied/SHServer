package org.example.dto;

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

//    @Field
//    private
}
