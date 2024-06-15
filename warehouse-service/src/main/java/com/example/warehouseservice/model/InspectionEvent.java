package com.example.warehouseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionEvent {
    private String eventId;
    private String shipmentId;
    private String status;
    private String remarks;
}