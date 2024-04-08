package org.example.testdto;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BelongsToCollection {

    @Field
    private Object backdrop_path;

    @Field
    private int id;

    @Field
    private String name;

    @Field
    private String poster_path;
}
