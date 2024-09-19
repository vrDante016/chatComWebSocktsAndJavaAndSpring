package com.chat.chat.service;

import com.chat.chat.model.Message;
import com.chat.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public MessageService(MessageRepository messageRepository, SimpMessagingTemplate simpMessagingTemplate) {
        this.messageRepository = messageRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    public Message processSaveMessageAndSend(Message message){
        message.setMoment(new Timestamp(System.currentTimeMillis()));
        messageRepository.save(message);

        simpMessagingTemplate.convertAndSend("/topic/public ", message);
        return message;
    }

    public List<Message> listAllMessages(Message message){
        return messageRepository.findAll();
    }
}
