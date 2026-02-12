package com.eventcom360.backend.controller;

import com.eventcom360.backend.model.InventoryItem;
import com.eventcom360.backend.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService s) {
        service = s;
    }

    @PostMapping
    public InventoryItem add(@RequestBody InventoryItem item) {
        return service.save(item);
    }
}
