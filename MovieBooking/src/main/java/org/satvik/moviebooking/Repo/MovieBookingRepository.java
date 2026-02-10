package org.satvik.moviebooking.Repo;

import org.satvik.moviebooking.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieBookingRepository {

    @Autowired
    private JdbcTemplate jdbc;

    // ================= THEATRE METHODS =================

    public List<Theatre> getTheatresByCity(String city) {
        String sql = "SELECT * FROM theatre WHERE city=?";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Theatre.class), city);
    }

    public List<Theatre> getAllTheatres() {
        String sql = "SELECT * FROM theatre";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Theatre.class));
    }

    public Theatre saveTheatre(Theatre theatre) {
        String sql = "INSERT INTO theatre(theatre_name, city) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, theatre.getTheatreName());
            ps.setString(2, theatre.getCity());
            return ps;
        }, keyHolder);

        theatre.setTheatreId(keyHolder.getKey().intValue());
        return theatre;
    }

    // ================= MOVIE METHODS =================

    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM movies";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Movie.class));
    }

    public Movie saveMovie(Movie movie) {
        String sql = "INSERT INTO movies(movie_name, genre) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, movie.getMovieName());
            ps.setString(2, movie.getGenre());
            return ps;
        }, keyHolder);

        movie.setMovieId(keyHolder.getKey().intValue());
        return movie;
    }

    // ================= SHOW METHODS =================

    public List<Show> getShows(int movieId, int theatreId) {
        String sql = "SELECT * FROM shows WHERE movie_id=? AND theatre_id=?";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Show.class), movieId, theatreId);
    }

    public List<Show> getAllShows() {
        String sql = "SELECT * FROM shows";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Show.class));
    }

    public Show saveShow(Show show) {
        String sql = "INSERT INTO shows(show_time, available_seats, movie_id, theatre_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, show.getShowTime());
            ps.setInt(2, show.getAvailableSeats());
            ps.setInt(3, show.getMovie().getMovieId());
            ps.setInt(4, show.getTheatre().getTheatreId());
            return ps;
        }, keyHolder);

        show.setShowId(keyHolder.getKey().intValue());
        return show;
    }

    // ================= SEAT METHODS =================

    public List<Seat> getSeats(int showId, List<String> seats) {
        String inSql = String.join(",", seats.stream().map(s -> "?").toList());
        String sql = "SELECT * FROM seat WHERE show_id=? AND seat_number IN (" + inSql + ")";

        List<Object> params = new ArrayList<>();
        params.add(showId);
        params.addAll(seats);

        return jdbc.query(sql, new BeanPropertyRowMapper<>(Seat.class), params.toArray());
    }

    public List<Seat> getAllSeats() {
        String sql = "SELECT * FROM seat";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Seat.class));
    }

    public Seat getSeatById(int seatId) {
        String sql = "SELECT * FROM seat WHERE seat_id=?";
        List<Seat> seats = jdbc.query(sql, new BeanPropertyRowMapper<>(Seat.class), seatId);
        return seats.isEmpty() ? null : seats.get(0);
    }

    public void markSeatBooked(List<String> seats, int showId) {
        String sql = "UPDATE seat SET is_booked=1 WHERE show_id=? AND seat_number=?";
        for (String seat : seats) {
            jdbc.update(sql, showId, seat);
        }
    }

    public void markSingleSeatBooked(int seatId) {
        String sql = "UPDATE seat SET is_booked=1 WHERE seat_id=?";
        jdbc.update(sql, seatId);
    }

    // ================= BOOKING METHODS =================

    public void saveBooking(Booking booking) {
        String sql = """
            INSERT INTO booking(user_id, show_id, seat_booked, total_price)
            VALUES (?, ?, ?, ?)
        """;
        jdbc.update(sql,
                booking.getUserId(),
                booking.getShowId(),
                booking.getSeatBooked(),
                booking.getTotalPrice());
    }

    public List<Booking> getAllBookings() {
        String sql = "SELECT * FROM booking";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Booking.class));
    }

    // ================= USER METHODS =================

    public User saveUser(User user) {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            return ps;
        }, keyHolder);

        user.setUserId(keyHolder.getKey().intValue());
        return user;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
