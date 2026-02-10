package org.satvik.moviebooking.Controller;

import org.satvik.moviebooking.Entity.Seat;
import org.satvik.moviebooking.Service.MovieBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "*")
public class SeatController {

    private final MovieBookingService service;

    public SeatController(MovieBookingService service) {
        this.service = service;
    }

    // Get all seats
    @GetMapping
    public List<Seat> getSeats() {
        return service.getAllSeats();
    }

    // Book a seat (update status)
    @PutMapping("/{seatId}/book")
    public Seat bookSeat(@PathVariable int seatId) {
        return service.bookSeat(seatId);
    }
}

