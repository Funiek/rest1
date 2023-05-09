package pl.ds360.rest1.service;

import pl.ds360.rest1.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    private List<Message> list = new ArrayList<>();

    public MessageService() {
        Message m1 = new Message(1L, "Pierwsza");
        Message m2 = new Message(2L, "Druga");
        Message m3 = new Message(3L, "Trzecia");

        list.add(m1);
        list.add(m2);
        list.add(m3);
    }

    public List<Message> getAllMessages() {
        return list;
    }
}
