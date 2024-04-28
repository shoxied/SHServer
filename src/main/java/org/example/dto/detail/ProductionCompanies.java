package org.example.dto.detail;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductionCompanies {

    private int id;
    private String logo_path;
    private String name;
    private String origin_country;
}
