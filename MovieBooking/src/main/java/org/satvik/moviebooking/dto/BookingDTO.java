package org.satvik.moviebooking.dto;

public class BookingDTO {

    private int bookingId;
    private int userId;
    private int showId;
    private String seatBooked;
    private double totalPrice;

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
