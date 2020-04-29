package com.jn.websocket.demo.common.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/greeting")
    public String greeting(String hello) {
        return "WebSocket-server: greeting, " + hello;
    }

}
