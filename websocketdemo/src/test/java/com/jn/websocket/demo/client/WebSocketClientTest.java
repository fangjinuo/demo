package com.jn.websocket.demo.client;

import org.junit.Test;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class WebSocketClientTest {
    private static WebSocketClient webSocketClient;
    private static WebSocketStompClient webSocketStompClient;
    private static ThreadPoolTaskScheduler taskScheduler;

    static {
        webSocketClient = new StandardWebSocketClient();
        webSocketStompClient = new WebSocketStompClient(webSocketClient);
        //new MappingJackson2MessageConverter()
        webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(100);
        webSocketStompClient.setTaskScheduler(taskScheduler);
    }

    @Test
    public void test() throws Throwable{
        String url = "ws://localhost:8088/console/websocket";
        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        ListenableFuture<StompSession> sessionFeature = webSocketStompClient.connect(url, sessionHandler);
        Thread.sleep(600000);
    }

}
