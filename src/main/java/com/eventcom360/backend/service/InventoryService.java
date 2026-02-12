package com.eventcom360.backend.service;

import com.eventcom360.backend.model.InventoryItem;
import com.eventcom360.backend.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository repo;

    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    public InventoryItem save(InventoryItem item) {
        return repo.save(item);
    }
}
