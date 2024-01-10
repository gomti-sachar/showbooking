package com.example.restservice.models;

public class SeatBooking {
    private Integer id;
    private Integer bookingId;
    private Integer seatId;

    public SeatBooking() {
    }

    public SeatBooking(Integer id, Integer bookingId, Integer seatId) {
        this.id = id;
        this.bookingId = bookingId;
        this.seatId = seatId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
}