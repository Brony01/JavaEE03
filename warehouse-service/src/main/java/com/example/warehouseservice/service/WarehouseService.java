package com.example.warehouseservice.service;

import com.example.warehouseservice.model.*;
import com.example.warehouseservice.websocket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {

    @Autowired
    private WebSocketService webSocketService;

    public void handleLogisticsEvent(LogisticsEvent event) {
        // 处理物流卸货事件
        System.out.println("Handling logistics event: " + event);
        // 更新仓库状态的逻辑
        // 发送 WebSocket 通知
        webSocketService.notifyClients("Logistics event processed: " + event);
    }

    public void handleInspectionEvent(InspectionEvent event) {
        // 处理检查和记录事件
        System.out.println("Handling inspection event: " + event);
        // 更新仓库状态的逻辑
        // 发送 WebSocket 通知
        webSocketService.notifyClients("Inspection event processed: " + event);
    }

    public void handleShipmentEvent(ShipmentEvent event) {
        // 处理出货装载事件
        System.out.println("Handling shipment event: " + event);
        // 更新仓库状态的逻辑
        // 发送 WebSocket 通知
        webSocketService.notifyClients("Shipment event processed: " + event);
    }
}
