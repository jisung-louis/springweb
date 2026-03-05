package example.day06.practice6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieDto {
    private Long id;
    private String title;
    private String director;
    private String releaseDate;
    private Double rating;

    private String createdAt;
    private String updatedAt;

    // toEntity()
    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .id(id)
                .title(title)
                .director(director)
                .releaseDate(releaseDate)
                .rating(rating)
                .build();
    }
}
