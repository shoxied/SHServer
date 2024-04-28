package org.example.dto.detail;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductionCountries {

    private String iso_3166_1;
    private String name;
}
