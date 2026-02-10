package org.satvik.moviebooking.Controller;

import org.satvik.moviebooking.Entity.Movie;
import org.satvik.moviebooking.Service.MovieBookingService;
import org.satvik.moviebooking.dto.MovieDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    private final MovieBookingService service;

    public MovieController(MovieBookingService service) {
        this.service = service;
    }

    // POST /api/movies
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }

    // GET /api/movies
    @GetMapping
    public List<MovieDTO> getAllMovies() {

        return service.getAllMovies().stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setMovieId(movie.getMovieId());
            dto.setMovieName(movie.getMovieName());
            return dto;
        }).toList();
    }
}
