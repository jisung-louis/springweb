package example.day06.practice6;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    // [1] 영화 등록
    public boolean addMovie(MovieDto movieDto){
        // [1] 엔티티화
        MovieEntity movieEntity = movieDto.toEntity();
        // [2] 저장
        MovieEntity save = movieRepository.save(movieEntity);
        // [3] 반환
        return save.getId() >= 1;
    }

    // [2] 영화 전체 조회 (모든 영화 목록을 조회)
    public List<MovieDto> findAllMovies(){
        List<MovieDto> movies = new ArrayList<>();
        List<MovieEntity> movieEntities = movieRepository.findAll();
        movieEntities.forEach(movieEntity -> {
            movies.add(movieEntity.toDto());
        });
        return movies;
    }

    // [3] 영화 개별 조회 (id를 기준으로 특정 영화 상세 정보 조회)
    public MovieDto findMovie(Long id){
        Optional<MovieEntity> movie = movieRepository.findById(id);
        if(movie.isPresent()){
            return movie.get().toDto();
        }
        return null;
    }

    // [4] 특정 영화 수정 (id를 기준으로 해당 영화 정보 수정, @Transactional)
    public boolean updateMovie(MovieDto movieDto){
        Optional<MovieEntity> optional = movieRepository.findById(movieDto.getId());
        if(optional.isPresent()){
            MovieEntity movieEntity = optional.get();

            movieEntity.setTitle(movieDto.getTitle());
            movieEntity.setDirector(movieDto.getDirector());
            movieEntity.setReleaseDate(movieDto.getReleaseDate());
            movieEntity.setRating(movieEntity.getRating());
            return true;
        }
        return false;
    }

    // [5] 특정 영화 삭제 (id를 기준으로 해당 영화 삭제)
    public boolean deleteMovie(Long id){
        movieRepository.deleteById(id);
        Optional<MovieEntity> optional = movieRepository.findById(id);
        return optional.isEmpty();
    }
}
