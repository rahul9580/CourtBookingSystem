package com.myorg.cbs.controller;

import com.myorg.cbs.ServiceUri;
import com.myorg.cbs.dtos.Academy;
import com.myorg.cbs.dtos.Booking;
import com.myorg.cbs.dtos.Slot;
import com.myorg.cbs.entities.CityEntity;
import com.myorg.cbs.service.AcademyService;
import com.myorg.cbs.service.BookingService;
import com.myorg.cbs.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(ServiceUri.BOOKING_BY_USER_ID_URL)
    private List<Booking> getAllBookingsByUserId(@PathVariable("userId") int userId) {
        return bookingService.getAllBookingsByUserId(userId);
    }

    @GetMapping(ServiceUri.BOOKING_BY_ID_URL)
    private Booking getBookingById(@PathVariable("id") int id) {
        return bookingService.getBookingsById(id);
    }

    @PostMapping(ServiceUri.BOOKING_BASE_URL)
    private int saveBooking(@RequestBody Booking booking) throws Exception {
        bookingService.saveOrUpdate(booking);
        return booking.getBookingId();
    }

    @GetMapping(ServiceUri.AVAILABLE_SLOTS_BY_COURT_ID_URL)
    private List<Slot> getAllAvailableSlots(@RequestParam int courtId, @RequestParam String date) throws Exception {
        String dateArr[] = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(dateArr[0]), Integer.valueOf(dateArr[1]), Integer.valueOf(dateArr[2]));
        return bookingService.getAllAvailableSlotsForCourt(courtId, localDate);
    }

}
