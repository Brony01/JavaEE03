package com.example.warehouseservice.kafka;

import com.example.basedomains.dto.WarehouseEvent;
import com.example.warehouseservice.service.WarehouseService;
import com.example.warehouseservice.model.InspectionEvent;
import com.example.warehouseservice.model.LogisticsEvent;
import com.example.warehouseservice.model.ShipmentEvent;
import com.example.warehouseservice.websocket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @Autowired
    private WebSocketService webSocketService;

    @Autowired
    private WarehouseService warehouseService;

    @KafkaListener(topics = "order_topic", groupId = "warehouse-group")
    public void consume(WarehouseEvent event) {
        // 处理订单事件并更新仓库状态
        System.out.println("Order event received: " + event);

        // 更新仓库状态的逻辑
        // ...

        // 发送 WebSocket 通知
        webSocketService.notifyClients("Order event processed: " + event);
    }

    @KafkaListener(topics = "logistics_topic", groupId = "warehouse-group")
    public void consumeLogisticsEvent(LogisticsEvent event) {
        warehouseService.handleLogisticsEvent(event);
        webSocketService.notifyClients("Logistics event processed: " + event);
    }

    @KafkaListener(topics = "inspection_topic", groupId = "warehouse-group")
    public void consumeInspectionEvent(InspectionEvent event) {
        warehouseService.handleInspectionEvent(event);
        webSocketService.notifyClients("Inspection event processed: " + event);
    }

    @KafkaListener(topics = "shipment_topic", groupId = "warehouse-group")
    public void consumeShipmentEvent(ShipmentEvent event) {
        warehouseService.handleShipmentEvent(event);
        webSocketService.notifyClients("Shipment event processed: " + event);
    }
}
