package com.example.websocketexample;

import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.MessageHandler;
import jakarta.websocket.Session;

import java.io.IOException;

public class WebSocketExample extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        session.addMessageHandler(new MessageHandler.Whole<String>() {

            @Override
            public void onMessage(String message) {
                try {
                    System.out.println(message);
                    session.getBasicRemote().sendText("You have send: " + message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
