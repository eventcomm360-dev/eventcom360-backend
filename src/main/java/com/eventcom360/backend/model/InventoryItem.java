package com.eventcom360.backend.model;

import jakarta.persistence.*;

@Entity
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int totalQty;
    private int rentedQty;

    public int getAvailableQty() {
        return totalQty - rentedQty;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getTotalQty() { return totalQty; }
    public void setTotalQty(int totalQty) { this.totalQty = totalQty; }

    public int getRentedQty() { return rentedQty; }
    public void setRentedQty(int rentedQty) { this.rentedQty = rentedQty; }
}
