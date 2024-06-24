package dev.drafting.event.manager.rest;

import dev.drafting.event.manager.model.MessageModel;
import dev.drafting.event.manager.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventRestImpl implements EventRest {
    private final MessageService messageService;

    public EventRestImpl(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void send(String message) {
        messageService.send(message);
    }

    @Override
    public List<MessageModel> findListAll() {
        return messageService.findListAll();
    }
}
