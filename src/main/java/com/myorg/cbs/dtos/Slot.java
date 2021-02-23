package com.myorg.cbs.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Slot {
    private LocalDateTime slotStartTime;
    private LocalDateTime slotEndTime;
}
