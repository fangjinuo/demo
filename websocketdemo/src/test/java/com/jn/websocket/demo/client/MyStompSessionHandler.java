package com.jn.websocket.demo.client;

import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {
    @Override
    public Type getPayloadType(StompHeaders headers) {
        return super.getPayloadType(headers);
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println((Message) payload);
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        session.subscribe("/topic", this);
        session.subscribe("/topic/myController/greeting", this);
        session.subscribe("/topic/myController/greeting2", this);
        session.subscribe("/queue/myController/greeting", this);
        session.subscribe("/queue/myController/greeting2", this);
        session.send("/topic", "send to /topic for broadcast");
        session.send("/queue", "send to /queue for p2p");

        /**
         *
         * destination 可以是 broker channel (/topic, /queue)
         * 也可以是： applicationDestinationPrefix + @MessageMapping_Controller + @MessageMapping_Method
         */
        StompSession.Receiptable receipt2 = session.send("/websocketApp/myController/greeting2", new String[]{"hello", "world"});
        StompSession.Receiptable receipt = session.send("/websocketApp/myController/greeting", "send to /websocketApp/myController/greeting");

    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        super.handleException(session, command, headers, payload, exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        super.handleTransportError(session, exception);
    }
}
