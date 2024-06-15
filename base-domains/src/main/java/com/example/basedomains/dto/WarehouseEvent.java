package com.example.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseEvent {
    private String eventId;
    private String eventType;
    private String warehouseLocation;
    private String goodsId;
    private String status;
}
