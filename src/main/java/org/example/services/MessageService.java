package org.example.services;

import org.example.domain.Message;
import org.example.repositories.MessageRepo;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageRepo repo;

    public MessageService(MessageRepo repo) {
        this.repo = repo;
    }

    public void save(Message message) {
        repo.save(message);
    }

    public Iterable<Message> findAll() {
        return repo.findAll();
    }
}
