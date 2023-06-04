package pl.ds360.rest1.service;

import pl.ds360.rest1.model.Message;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Singleton
public class MessageService {
    private Map<Long, Message> list;

    @PostConstruct
    private void init() {
        Message m1 = new Message(1L, "Pierwsza");
        Message m2 = new Message(2L, "Druga");
        Message m3 = new Message(3L, "Trzecia");

        list = new HashMap<>();
        list.put(1L, m1);
        list.put(2L, m2);
        list.put(3L, m3);
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(list.values());
    }

    public Message getMessage(Long id) { return list.get(id); }

    public Message addMessage(Message message) {
        message.setId(list.size() + 1L);
        list.put(list.size() + 1L, message);

        return message;
    }

    public Message updateMessage(Message message) {
        list.put(message.getId(), message);

        return message;
    }

    public void deleteMessage(Long messageId) {
        Map<Long, Message> tempList = list;
        tempList.remove(messageId);
        list = tempList;

    }

    public List<Message> getAllMessagesStartingWith(String par1) {
        return list.values().stream()
                .filter(e -> e.getMessage().startsWith(par1))
                .collect(Collectors.toList());
    }
}
