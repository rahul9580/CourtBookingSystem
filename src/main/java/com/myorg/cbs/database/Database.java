package com.myorg.cbs.database;

import com.myorg.cbs.dtos.Court;
import com.myorg.cbs.entities.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Database {
    public static Map<Integer, UserEntity> userTable = new HashMap<>();
    public static Map<Integer, CityEntity> cityTable = new HashMap<>();
    public static Map<Integer, AcademyEntity> academyTable = new HashMap<>();
    public static Map<Integer, CourtEntity> courtTable = new HashMap<>();
    public static Map<Integer, GameEntity> gameTable = new HashMap<>();
    public static Map<Integer, BookingEntity> bookingTable = new HashMap<>();

}
