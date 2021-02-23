package com.myorg.cbs.entities;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class AcademyEntity {
    private int academyId;
    private List<CourtEntity> courts;
    private CityEntity cityEntity;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String academyName;
    private String ownerName;
    private String ownerEmail;
    private String address;
}
