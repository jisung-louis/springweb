package example.day06.practice6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "movie")
public class MovieEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;
    @Column(nullable = false)
    private String title;
    private String director;
    private String releaseDate;
    private Double rating;

    // toDto()
    public MovieDto toDto(){
        return MovieDto.builder()
                .id(id)
                .title(title)
                .director(director)
                .releaseDate(releaseDate)
                .rating(rating)
                .createdAt(getCreatedAt().toString())
                .updatedAt(getUpdatedAt().toString())
                .build();
    }
}
