package org.satvik.moviebooking.Service;

import org.satvik.moviebooking.Entity.*;
import org.satvik.moviebooking.Repo.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieBookingService {

    @Autowired
    private MovieBookingRepository repo;

    // ================= THEATRE METHODS =================

    public List<Theatre> getTheatres(String city) {
        return repo.getTheatresByCity(city);
    }

    public List<Theatre> getAllTheatres() {
        return repo.getAllTheatres();
    }

    public Theatre saveTheatre(Theatre theatre) {
        return repo.saveTheatre(theatre);
    }

    // ================= MOVIE METHODS =================

    public Movie saveMovie(Movie movie) {
        return repo.saveMovie(movie);
    }

    public List<Movie> getAllMovies() {
        return repo.getAllMovies();
    }

    // ================= SHOW METHODS =================

    public List<Show> getShows(int movieId, int theatreId) {
        return repo.getShows(movieId, theatreId);
    }

    public List<Show> getAllShows() {
        return repo.getAllShows();
    }

    public Show saveShow(Show show) {
        return repo.saveShow(show);
    }

    // ================= SEAT METHODS =================

    public List<Seat> getAllSeats() {
        return repo.getAllSeats();
    }

    public Seat bookSeat(int seatId) {
        Seat seat = repo.getSeatById(seatId);

        if (seat == null) {
            throw new RuntimeException("Seat not found");
        }

        if (seat.isBooked()) {
            throw new RuntimeException("Seat already booked");
        }

        repo.markSingleSeatBooked(seatId);
        seat.setBooked(true);
        return seat;
    }

    // ================= BOOKING METHODS =================

    public String bookTicket(int userId, int showId, List<String> seats) {
        List<Seat> seatList = repo.getSeats(showId, seats);

        // Validate all requested seats exist
        if (seatList.size() != seats.size()) {
            return "One or more seats not found";
        }

        // Check if any seat is already booked
        for (Seat s : seatList) {
            if (s.isBooked()) {
                return "Seat " + s.getSeatNumber() + " already booked";
            }
        }

        // Mark seats as booked
        repo.markSeatBooked(seats, showId);

        // Create booking record
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setShowId(showId);
        booking.setSeatBooked(String.join(",", seats));
        booking.setTotalPrice(seats.size() * 200);

        repo.saveBooking(booking);

        return "Booking successful";
    }

    public List<Booking> getAllBookings() {
        return repo.getAllBookings();
    }

    // ================= USER METHODS =================

    public User saveUser(User user) {
        return repo.saveUser(user);
    }

    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }
}
