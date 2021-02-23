package com.myorg.cbs.converter;

import com.myorg.cbs.dtos.*;
import com.myorg.cbs.entities.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ObjectConverter {

    public static AcademyEntity convertAcademy(Academy academy) {
        AcademyEntity academyEntity = new AcademyEntity();
        BeanUtils.copyProperties(academy, academyEntity);
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCityId(academy.getCityId());
        academyEntity.setCityEntity(cityEntity);
        return academyEntity;
    }

    public static List<AcademyEntity> convertAcademy(List<Academy> academies) {
        List<AcademyEntity> academyEntities = new ArrayList<>();
        for(Academy academy : academies) {
            academyEntities.add(convertAcademy(academy));
        }
        return academyEntities;
    }

    public static Academy convertAcademyEntity(AcademyEntity academyEntity) {
        Academy academy = new Academy();
        BeanUtils.copyProperties(academyEntity, academy);
        academy.setCityId(academyEntity.getCityEntity().getCityId());
        return academy;
    }

    public static List<Academy> convertAcademyEntities(List<AcademyEntity> academyEntities) {
        List<Academy> academies = new ArrayList<>();
        for(AcademyEntity academyEntity : academyEntities) {
            academies.add(convertAcademyEntity(academyEntity));
        }
        return academies;
    }

    public static CourtEntity convertCourt(Court court) {
        CourtEntity courtEntity = new CourtEntity();
        BeanUtils.copyProperties(court, courtEntity);
        AcademyEntity academyEntity = new AcademyEntity();
        academyEntity.setAcademyId(court.getAcademyId());
        courtEntity.setAcademyEntity(academyEntity);
        GameEntity gameEntity = new GameEntity();
        gameEntity.setGameId(court.getGameId());
        courtEntity.setGameEntity(gameEntity);
        return courtEntity;
    }

    public static List<CourtEntity> convertCourt(List<Court> courts) {
        List<CourtEntity> courtEntities = new ArrayList<>();
        for(Court court : courts) {
            courtEntities.add(convertCourt(court));
        }
        return courtEntities;
    }

    public static Court convertCourtEntity(CourtEntity courtEntity) {
        Court court = new Court();
        BeanUtils.copyProperties(courtEntity, court);
        court.setAcademyId(courtEntity.getAcademyEntity().getAcademyId());
        court.setGameId(courtEntity.getGameEntity().getGameId());
        return court;
    }

    public static List<Court> convertCourtEntities(List<CourtEntity> courtEntries) {
        List<Court> courts = new ArrayList<>();
        for(CourtEntity courtEntity : courtEntries) {
            courts.add(convertCourtEntity(courtEntity));
        }
        return courts;
    }

    public static GameEntity convertGame(Game game) {
        GameEntity gameEntity = new GameEntity();
        BeanUtils.copyProperties(game, gameEntity);
        return gameEntity;
    }

    public static List<GameEntity> convertGame(List<Game> games) {
        List<GameEntity> gameEntities = new ArrayList<>();
        for(Game game : games) {
            gameEntities.add(convertGame(game));
        }
        return gameEntities;
    }

    public static Game convertGameEntity(GameEntity gameEntity) {
        Game game = new Game();
        BeanUtils.copyProperties(gameEntity, game);
        return game;
    }

    public static List<Game> convertGameEntities(List<GameEntity> gameEntities) {
        List<Game> games = new ArrayList<>();
        for(GameEntity gameEntity : gameEntities) {
            games.add(convertGameEntity(gameEntity));
        }
        return games;
    }

    public static BookingEntity convertBooking(Booking booking) {
        BookingEntity bookingEntity = new BookingEntity();
        BeanUtils.copyProperties(booking, bookingEntity);
        CourtEntity courtEntity = new CourtEntity();
        courtEntity.setCourtId(booking.getCourtId());
        bookingEntity.setCourtEntity(courtEntity);
        GameEntity gameEntity = new GameEntity();
        gameEntity.setGameId(booking.getGameId());
        bookingEntity.setGameEntity(gameEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(booking.getUserId());
        bookingEntity.setUserEntity(userEntity);
        return bookingEntity;
    }

    public static List<BookingEntity> convertBookings(List<Booking> bookings) {
        List<BookingEntity> bookingEntities = new ArrayList<>();
        for(Booking booking : bookings) {
            bookingEntities.add(convertBooking(booking));
        }
        return bookingEntities;
    }

    public static Booking convertBookingEntity(BookingEntity bookingEntity) {
        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingEntity, booking);
        booking.setCourtId(bookingEntity.getCourtEntity().getCourtId());
        booking.setGameId(bookingEntity.getGameEntity().getGameId());
        booking.setUserId(bookingEntity.getUserEntity().getUserId());
        return booking;
    }

    public static List<Booking> convertBookingEntities(List<BookingEntity> bookingEntities) {
        List<Booking> bookings = new ArrayList<>();
        for(BookingEntity bookingEntity : bookingEntities) {
            bookings.add(convertBookingEntity(bookingEntity));
        }
        return bookings;
    }

    public static UserEntity convertUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return userEntity;
    }

    public static User convertUserEntity(UserEntity userEntity) {
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }
}
