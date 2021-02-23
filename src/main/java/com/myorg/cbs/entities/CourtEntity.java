package com.myorg.cbs.entities;

import lombok.Data;

import java.time.LocalTime;

@Data
public class CourtEntity {
    private int courtId;
    private AcademyEntity academyEntity;
    private GameEntity gameEntity;
    private LocalTime openTime;
    private LocalTime closeTime;
    int minSlotTime;   //60
    int slotFrequency; //60
    int pricePerUnitSlot;
    int discount;
}
