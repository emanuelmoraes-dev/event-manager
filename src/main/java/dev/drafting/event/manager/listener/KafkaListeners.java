package dev.drafting.event.manager.listener;

import dev.drafting.event.manager.service.MessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private final MessageService messageService;

    public KafkaListeners(MessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = "${event-manager.kafka.topic}", groupId = "${event-manager.kafka.group}")
    public void listen(String message) {
        messageService.process(message);
    }
}
