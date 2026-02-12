package com.eventcom360.backend.dto.req;

import java.time.LocalDate;

public class BookingRequest {

    public Long userId;
    public Long inventoryId;
    public int qty;

    public LocalDate startDate;
    public LocalDate returnDate;

}
