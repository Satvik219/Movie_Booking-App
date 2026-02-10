package org.satvik.moviebooking.dto;

public class BookingResponseDTO {

    private String message;
    private double totalPrice;
    private String seats;

    public BookingResponseDTO(String message, double totalPrice, String seats) {
        this.message = message;
        this.totalPrice = totalPrice;
        this.seats = seats;
    }

    public String getMessage() {
        return message;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getSeats() {
        return seats;
    }
}

