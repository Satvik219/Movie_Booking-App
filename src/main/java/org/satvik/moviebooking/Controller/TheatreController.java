package org.satvik.moviebooking.Controller;

import org.satvik.moviebooking.Entity.Theatre;
import org.satvik.moviebooking.Service.MovieBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
@CrossOrigin(origins = {"*"})  // We'll update this after deployment
public class TheatreController {

    private final MovieBookingService service;

    public TheatreController(MovieBookingService service) {
        this.service = service;
    }

    @PostMapping
    public Theatre addTheatre(@RequestBody Theatre theatre) {
        return service.saveTheatre(theatre);
    }

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return service.getAllTheatres();
    }
}

