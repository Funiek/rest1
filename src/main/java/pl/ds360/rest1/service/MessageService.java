package pl.ds360.rest1.service;

import pl.ds360.rest1.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService {
    private static Map<Long, Message> list = new HashMap<>();

    public MessageService() {
        Message m1 = new Message(1L, "Pierwsza");
        Message m2 = new Message(2L, "Druga");
        Message m3 = new Message(3L, "Trzecia");

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
        list.put(list.size() + 1L, message);

        return message;
    }

    public void deleteMessage(Long messageId) {
//        Message m1 = new Message(messageId, "Pierwsza");
//        Message m2 = new Message(messageId, "Druga");
//        Message m3 = new Message(messageId, "Trzecia");
//
//        list.put(4L, m1);
//        list.put(5L, m2);
//        list.put(6L, m3);
//        list.remove(5L);
        list.remove(messageId);
        list.remove(messageId);
    }
}
