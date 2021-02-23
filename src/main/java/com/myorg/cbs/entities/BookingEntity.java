package com.myorg.cbs.entities;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingEntity {
    private int bookingId;
    private CourtEntity courtEntity;
    private GameEntity gameEntity;
    private UserEntity userEntity;
    private LocalDate bookingDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int totalPrice;
    private int discount;
}
