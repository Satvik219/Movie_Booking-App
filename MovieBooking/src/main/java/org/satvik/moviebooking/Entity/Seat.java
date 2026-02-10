package org.satvik.moviebooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private int seatId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "is_booked")
    private boolean isBooked;

    @Column(name = "show_id")
    private int showId;

    // Constructors
    public Seat() {}

    public Seat(String seatNumber, boolean isBooked, int showId) {
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
        this.showId = showId;
    }

    // Getters and Setters
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }
}
