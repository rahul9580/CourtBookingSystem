package com.myorg.cbs.dtos;

import lombok.Data;

import java.time.LocalTime;

@Data
public class Court {
    private int courtId;
    private int academyId;
    private int gameId;
    private LocalTime openTime;
    private LocalTime closeTime;
    private int minSlotTime;
    private int slotFrequency;
    private int pricePerUnitSlot;
    private int discount;
}
