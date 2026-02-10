package org.satvik.moviebooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "show_id")
    private int showId;

    @Column(name = "seat_booked")
    private String seatBooked;

    @Column(name = "total_price")
    private double totalPrice;

    // Constructors
    public Booking() {}

    public Booking(int userId, int showId, String seatBooked, double totalPrice) {
        this.userId = userId;
        this.showId = showId;
        this.seatBooked = seatBooked;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(String seatBooked) {
        this.seatBooked = seatBooked;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
