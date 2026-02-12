package com.eventcom360.backend.controller;

import com.eventcom360.backend.dto.req.BookingRequest;
import com.eventcom360.backend.model.Booking;
import com.eventcom360.backend.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService s) {
        service = s;
    }

    @PostMapping
    public Booking create(@RequestBody BookingRequest req) {
        return service.create(req);
    }

    @PostMapping("/{id}/return")
    public void returnBooking(@PathVariable Long id) {
        service.returnBooking(id);
    }
}
