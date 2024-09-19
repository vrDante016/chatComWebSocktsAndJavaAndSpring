package com.chat.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        //Define o broker para enviar mensagens para os clientes inscritos
        config.enableSimpleBroker("/topic");
        // Define o prefixo para as mensagens enviadas do cliente para o servidor
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //Regista o endpoit WebSocket e habilita sockJs como fallback
        registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("http://127.0.0.1:5500").withSockJS();
    }


}
