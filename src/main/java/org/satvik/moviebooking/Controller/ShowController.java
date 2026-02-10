package org.satvik.moviebooking.Controller;

import org.satvik.moviebooking.Entity.Show;
import org.satvik.moviebooking.Service.MovieBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = {"*"})  // We'll update this after deployment
public class ShowController {

    private final MovieBookingService service;

    public ShowController(MovieBookingService service) {
        this.service = service;
    }

    @PostMapping
    public Show addShow(@RequestBody Show show) {
        return service.saveShow(show);
    }

    @GetMapping
    public List<Show> getAllShows() {
        return service.getAllShows();
    }
}

