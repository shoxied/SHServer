package org.example.dto.detail;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BelongsToCollection {

    private int id;
    private String name;
    private String poster_path;
    private String backdrop_path;
}
