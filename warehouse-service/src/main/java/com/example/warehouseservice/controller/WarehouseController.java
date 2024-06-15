package com.example.warehouseservice.controller;

import com.example.warehouseservice.model.*;
import com.example.warehouseservice.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/warehouses")
public class WarehouseController {

    @GetMapping("/{warehouseId}")
    public Warehouse getWarehouse(@PathVariable String warehouseId) {
        // 返回仓库信息
        return new Warehouse(warehouseId, "Main Location", 1000, 500);
    }

    @PostMapping
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        // 创建仓库记录
        return warehouse;
    }

    @PutMapping("/{warehouseId}")
    public Warehouse updateWarehouse(@PathVariable String warehouseId, @RequestBody Warehouse warehouse) {
        // 更新仓库记录
        return warehouse;
    }

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/logistics")
    public void handleLogisticsEvent(@RequestBody LogisticsEvent event) {
        warehouseService.handleLogisticsEvent(event);
    }

    @PostMapping("/inspection")
    public void handleInspectionEvent(@RequestBody InspectionEvent event) {
        warehouseService.handleInspectionEvent(event);
    }

    @PostMapping("/shipment")
    public void handleShipmentEvent(@RequestBody ShipmentEvent event) {
        warehouseService.handleShipmentEvent(event);
    }
}
