package org.satvik.moviebooking.dto;

public class ShowDTO {

    private int showId;
    private int movieId;
    private int theatreId;
    private String showTime;

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}

