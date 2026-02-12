package com.eventcom360.backend.service;

import com.eventcom360.backend.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    private final BookingRepository repo;

    public AnalyticsService(BookingRepository repo) {
        this.repo = repo;
    }

    public long totalBookings() {
        return repo.count();
    }
}
