package com.jn.websocket.demo.common.controller;

import com.jn.langx.util.Strings;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/myController")
public class WebSocketController {
    @MessageMapping("/greeting")
    public String greeting(String hello) {
        return "WebSocket-server: greeting, " + hello;
    }

    @MessageMapping("/greeting2")
    public String greeting2(String[] hello) {
        return "WebSocket-server: greeting, " + Strings.join(",", hello);
    }
}
