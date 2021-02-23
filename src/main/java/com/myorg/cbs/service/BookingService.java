package com.myorg.cbs.service;

import com.myorg.cbs.converter.ObjectConverter;
import com.myorg.cbs.dao.BookingDao;
import com.myorg.cbs.dtos.*;
import com.myorg.cbs.entities.BookingEntity;
import com.myorg.cbs.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class BookingService {

    Map<Integer, Object> courtLocksMap = new HashMap<>();

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private CourtService courtService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    public int bookASlot(int userId, int cityId, int courtId, int gameId, Slot slot) {
        return 0;
    }

    public List<Booking> getAllBookingsByUserId(int userId) {
        List<Booking> bookings = new ArrayList<>();
        List<BookingEntity> bookingEntities = bookingDao.getAllBookingsByUserId(userId);
        if(Objects.nonNull(bookingEntities)) {
            bookings = ObjectConverter.convertBookingEntities(bookingEntities);
        }
        return bookings;
    }

    public Booking getBookingsById(int id) {
        Booking booking = null;
        BookingEntity bookingEntity = bookingDao.getBookingsById(id);
        if(Objects.nonNull(bookingEntity)) {
            booking = ObjectConverter.convertBookingEntity(bookingEntity);
        }
        return booking;
    }

    public void saveOrUpdate(Booking booking) throws Exception {
        UserEntity userEntity = userService.getUserById(booking.getUserId());
        if(Objects.isNull(userEntity)) {
            // Through below exception if you don't want to support guest user
            //throw new Exception("User does not exist");
        }
        Court court = courtService.getCourtById(booking.getCourtId());
        if(Objects.isNull(court)) {
            throw new Exception("Court does not exist");
        }
        Game game = gameService.getGameById(booking.getGameId());
        if(Objects.isNull(game)) {
            throw new Exception("Game does not exist");
        }
        BookingEntity bookingEntity = ObjectConverter.convertBooking(booking);
        bookingEntity.setUserEntity(userEntity);
        bookingEntity.setGameEntity(ObjectConverter.convertGame(game));

        int price = calculateBookingAmount(court, booking.getStartTime(), booking.getEndTime());
        bookingEntity.setTotalPrice(price);

        // Validate Slot and book after locking court object
        Object lock = getLockForCourt(court.getCourtId());
        synchronized (lock) {
            List<Slot> availableSlots = getAllAvailableSlotsForCourt(court, booking.getBookingDate());
            boolean isValidSlot = false;
            for(Slot slot : availableSlots) {
                if((booking.getStartTime().equals(slot.getSlotStartTime()) || booking.getStartTime().isAfter(slot.getSlotStartTime()))
                        && (booking.getEndTime().equals(slot.getSlotEndTime()) || booking.getEndTime().isBefore(slot.getSlotEndTime()))) {
                    isValidSlot = true;
                    break;
                }
            }
            if(!isValidSlot) {
                throw new Exception("Given slot is not available.");
            }
            bookingDao.saveOrUpdate(bookingEntity);
        }

    }

    private synchronized Object getLockForCourt(int courtId) {
        Object object = courtLocksMap.get(courtId);
        if(Objects.isNull(object)) {
            object = new Object();
            courtLocksMap.put(courtId, object);
        }
        return object;
    }

    private int calculateBookingAmount(Court court, LocalDateTime bookingStartTime, LocalDateTime bookingEndTime) throws Exception {
        long bookingDuration = bookingStartTime.until(bookingEndTime, ChronoUnit.MINUTES);
        validateBookingSlot(court, bookingDuration);
        return (int) (court.getPricePerUnitSlot() * (bookingDuration/court.getSlotFrequency()));
    }

    private void validateBookingSlot(Court court, long bookingDuration) throws Exception {
        if(bookingDuration < court.getMinSlotTime()) {
            throw new Exception("Minimum slot time for this court is " + court.getMinSlotTime() + " minutes");
        }
        if(bookingDuration%court.getSlotFrequency() != 0) {
            throw new Exception("Slot frequency for this court is " + court.getSlotFrequency() + " minutes");
        }
    }

    public List<Slot> getAllAvailableSlotsForCourt(int courtId, LocalDate date) throws Exception {
        Court court = courtService.getCourtById(courtId);
        if(Objects.isNull(court)) {
            throw new Exception("Court does not exists.");
        }
        return getAllAvailableSlotsForCourt(court, date);
    }

    private List<Slot> getAllAvailableSlotsForCourt(Court court, LocalDate date) {
        List<BookingEntity> bookings = bookingDao.getAllBookingByCourtId(court.getCourtId(), date);
        Comparator<BookingEntity> comparator = new Comparator<BookingEntity>() {
            @Override
            public int compare(BookingEntity o1, BookingEntity o2) {
                return o1.getStartTime().isBefore(o2.getStartTime()) ? -1 : 1;
            }
        };

        List<Slot> slots = new ArrayList<>();
        Collections.sort(bookings, comparator);
        LocalTime courtOpenTime = court.getOpenTime();
        LocalDateTime slotStartTime = LocalDateTime.of(date, courtOpenTime);
        for(BookingEntity bookingEntity : bookings) {
            if(!slotStartTime.equals(bookingEntity.getStartTime())) {
                LocalDateTime slotEndTime = bookingEntity.getStartTime();
                Slot slot = new Slot();
                slot.setSlotStartTime(slotStartTime);
                slot.setSlotEndTime(slotEndTime);
                slots.add(slot);
            }
            slotStartTime = bookingEntity.getEndTime();
        }
        Slot slot = new Slot();
        slot.setSlotStartTime(slotStartTime);
        LocalDateTime courtCloseTime = LocalDateTime.of(date, court.getCloseTime());
        slot.setSlotEndTime(courtCloseTime);
        slots.add(slot);

        return slots;
    }
}
