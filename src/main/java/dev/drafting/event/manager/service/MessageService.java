package dev.drafting.event.manager.service;

import dev.drafting.event.manager.model.MessageModel;

import java.util.List;

public interface MessageService {
    void send(String content);
    void process(String content);
    List<MessageModel> findListAll();
}
