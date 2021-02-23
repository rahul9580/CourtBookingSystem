package com.myorg.cbs.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Booking {
    private int bookingId; //uuid
    private int courtId;
    private int gameId;
    private int userId;
    private LocalDate bookingDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int totalPrice;
    private int discount;
}
