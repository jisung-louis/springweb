package example.day06.practice6;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public boolean addMovie(@RequestBody MovieDto movieDto){
        return movieService.addMovie(movieDto);
    }
    @GetMapping
    public List<MovieDto> getAllMovies(){
        return movieService.findAllMovies();
    }
    @GetMapping("/detail")
    public MovieDto getMovie(@RequestParam Long id){
        return movieService.findMovie(id);
    }
    @PutMapping
    public boolean updateMovie(@RequestBody MovieDto movieDto){
        return movieService.updateMovie(movieDto);
    }
    @DeleteMapping
    public boolean deleteMovie(@RequestParam Long id){
        return movieService.deleteMovie(id);
    }
}
