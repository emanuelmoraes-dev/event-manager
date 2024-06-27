package dev.drafting.event.manager.service;

import dev.drafting.event.manager.model.MessageModel;
import dev.drafting.event.manager.repository.dynamo.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final MessageRepository messageRepository;
    private final KafkaTemplate<String, String> kafka;
    private final String kafkaTopic;

    public MessageServiceImpl(MessageRepository messageRepository, KafkaTemplate<String, String> kafka,
                              @Value("${event-manager.kafka.topic}") String kafkaTopic) {
        this.messageRepository = messageRepository;
        this.kafka = kafka;
        this.kafkaTopic = kafkaTopic;
    }

    @Override
    public void send(String content) {
        final MessageModel model = new MessageModel();
        model.setContent(content);
        messageRepository.save(model);
        kafka.send(kafkaTopic, content);
    }

    @Override
    public void process(String content) {
        LOG.info("message: {}", content);
    }

    @Override
    public List<MessageModel> findListAll() {
        final List<MessageModel> list = new ArrayList<>();
        messageRepository.findAll().forEach(list::add);
        return list;
    }
}
