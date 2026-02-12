package com.eventcom360.backend.controller;

import com.eventcom360.backend.dto.res.AnalyticsResponse;
import com.eventcom360.backend.service.AnalyticsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService s) {
        service = s;
    }

    @GetMapping
    public AnalyticsResponse get() {
        AnalyticsResponse res = new AnalyticsResponse();
        res.totalBookings = service.totalBookings();
        return res;
    }
}
