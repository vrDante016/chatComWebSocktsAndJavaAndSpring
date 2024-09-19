package com.chat.chat.controller;

import com.chat.chat.model.Message;
import com.chat.chat.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SendTo("/topic/public")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/send")
    public Message sendMessage(Message message){
       return messageService.processSaveMessageAndSend(message);
    }

}
