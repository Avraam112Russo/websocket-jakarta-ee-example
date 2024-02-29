package com.example.websocketexample;

import jakarta.websocket.Endpoint;
import jakarta.websocket.server.ServerApplicationConfig;
import jakarta.websocket.server.ServerEndpointConfig;

import java.util.HashSet;
import java.util.Set;

public class WebSocketConfig implements ServerApplicationConfig {
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        Set<ServerEndpointConfig> endpointConfigSet = new HashSet<>();
        for (Class aClass : set) {
            if (aClass.equals(WebSocketExample.class)) {
                ServerEndpointConfig config = ServerEndpointConfig.Builder.create(aClass, "/echo").build();
                endpointConfigSet.add(config);
            }
            if (aClass.equals(WebSocketExample.class)) {
                ServerEndpointConfig config = ServerEndpointConfig.Builder.create(aClass, "/echoMessage").build();
                endpointConfigSet.add(config);
            }
        }
            return endpointConfigSet;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        return null;
    }

}
