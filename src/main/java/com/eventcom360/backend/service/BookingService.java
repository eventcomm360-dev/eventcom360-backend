package com.eventcom360.backend.service;

import com.eventcom360.backend.dto.req.BookingRequest;
import com.eventcom360.backend.model.*;
import com.eventcom360.backend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookingService {

    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final InventoryRepository inventoryRepo;

    public BookingService(BookingRepository b, UserRepository u, InventoryRepository i) {
        bookingRepo = b;
        userRepo = u;
        inventoryRepo = i;
    }

    public Booking create(BookingRequest req) {

        User user = userRepo.findById(req.userId).orElseThrow();
        InventoryItem item = inventoryRepo.findById(req.inventoryId).orElseThrow();

        if (item.getAvailableQty() < req.qty)
            throw new RuntimeException("Not enough stock");

        item.setRentedQty(item.getRentedQty() + req.qty);

        Booking b = new Booking();
        b.setClient(user);
        b.setStartDate(req.startDate);
        b.setReturnDate(req.returnDate);
        b.setStatus("ACTIVE");

        return bookingRepo.save(b);
    }

    public void returnBooking(Long id) {
        Booking b = bookingRepo.findById(id).orElseThrow();
        b.setStatus("RETURNED");
    }
}
