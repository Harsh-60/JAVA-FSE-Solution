package com.springcore.service;

import com.springcore.repository.MessageRepository;

public class NotificationService {

    private MessageRepository repository;

    // Setter Injection
    public void setRepository(MessageRepository repository) {
        this.repository = repository;
    }

    public void sendNotification() {
        System.out.println(repository.getMessage());
    }
}
