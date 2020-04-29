package com.jn.websocket.demo.common.controller;

import com.jn.langx.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;


@Controller
@MessageMapping("/myController")
public class WebSocketController {
    private SimpMessagingTemplate template;

    @Autowired
    public void setTemplate(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/greeting")
    public String greeting(String hello) {
        return "WebSocket-server: greeting, " + hello;
    }

    @MessageMapping("/greeting2")
    public void greeting2(String[] hello) {
        Map<String, Object> headers = new HashMap<>();
        //headers.put(SimpMessageHeaderAccessor.MESSAGE_TYPE_HEADER, SimpMessageType.CONNECT);
        //headers.put(SimpMessageHeaderAccessor.DESTINATION_HEADER,"/topic/myController/greeting2");
        headers.put("__destination__", "/topic/myController/greeting2/node_id_001");
        String payload = "WebSocket-server: greeting, " + Strings.join(",", hello);
        this.template.convertAndSend("/topic/myController/greeting2", payload, headers);

    }

    @MessageMapping("/greeting3")
    public void greeting3(String[] hello) {
        Map<String, Object> headers = new HashMap<>();
        //headers.put(SimpMessageHeaderAccessor.MESSAGE_TYPE_HEADER, SimpMessageType.CONNECT);
        //headers.put(SimpMessageHeaderAccessor.DESTINATION_HEADER,"/topic/myController/greeting2");
        String payload = "WebSocket-server: greeting, " + Strings.join(",", hello);
        this.template.convertAndSend("/topic/myController/greeting333", payload, headers);

    }
}
