package com.example.warehouseservice.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private WebSocketHandler webSocketHandler;

    public void notifyClients(String message) {
        webSocketHandler.sendMessageToAll(message);
    }
}
