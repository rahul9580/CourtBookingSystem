package com.myorg.cbs.dao;

import com.myorg.cbs.database.Database;
import com.myorg.cbs.entities.BookingEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BookingDao {

    public List<BookingEntity> getAllBookingsByUserId(int userId) {
        List<BookingEntity> bookingEntities = new ArrayList<>();
        for(Map.Entry<Integer, BookingEntity> entry : Database.bookingTable.entrySet()) {
            if(userId == entry.getValue().getUserEntity().getUserId()) {
                bookingEntities.add(entry.getValue());
            }
        }

        return bookingEntities;
    }

    public List<BookingEntity> getAllBookingByCourtId(int courtId, LocalDate date) {
        List<BookingEntity> bookingEntities = new ArrayList<>();
        for(Map.Entry<Integer, BookingEntity> entry : Database.bookingTable.entrySet()) {
            if(date.equals(entry.getValue().getBookingDate()) && courtId == entry.getValue().getCourtEntity().getCourtId()) {
                bookingEntities.add(entry.getValue());
            }
        }

        return bookingEntities;
    }

    public BookingEntity getBookingsById(int id) {
        return Database.bookingTable.get(id);
    }

    public void saveOrUpdate(BookingEntity bookingEntity) {
        Database.bookingTable.put(bookingEntity.getBookingId(), bookingEntity);
    }
}
