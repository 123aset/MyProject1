package com.example.demo.service;

import com.example.demo.entity.Message;
import com.example.demo.entity.Users;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Page<Message> messageList(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty())
            return messageRepository.findByTag(filter, pageable);
        else
            return messageRepository.findAll(pageable);
    }

    public Page<Message> messageListForUser(Pageable pageable, Users currentUser, Users author) {
        return messageRepository.findByUser(pageable,author);
    }
}
