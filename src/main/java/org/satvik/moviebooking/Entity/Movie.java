package org.satvik.moviebooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "genre")
    private String genre;

    // Constructors
    public Movie() {}

    public Movie(String movieName, String genre) {
        this.movieName = movieName;
        this.genre = genre;
    }

    // Getters and Setters
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
