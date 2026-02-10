package org.satvik.moviebooking.Controller;

import org.satvik.moviebooking.Service.MovieBookingService;
import org.satvik.moviebooking.dto.BookingRequestDTO;
import org.satvik.moviebooking.dto.BookingResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = {"*"})  // We'll update this after deployment
public class BookingController {

    private final MovieBookingService service;

    public BookingController(MovieBookingService service) {
        this.service = service;
    }

    // POST /api/bookings/book
    @PostMapping("/book")
    public BookingResponseDTO bookTicket(@RequestBody BookingRequestDTO dto) {

        String message = service.bookTicket(
                dto.getUserId(),
                dto.getShowId(),
                dto.getSeats()
        );

        return new BookingResponseDTO(
                message,
                dto.getSeats().size() * 200,
                String.join(",", dto.getSeats())
        );
    }
}
