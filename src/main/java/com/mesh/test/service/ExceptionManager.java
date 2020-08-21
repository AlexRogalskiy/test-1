package com.mesh.test.service;

import com.mesh.test.service.entity.Message;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;

@Service
public class ExceptionManager {
    private Message lastMessage;
    private final DateTimeManager dateTimeManager;

    public ExceptionManager(DateTimeManager dateTimeManager) {
        this.dateTimeManager = dateTimeManager;
        this.lastMessage = new Message(null, null);
    }

    public <T extends WebApplicationException> void doThrow(T exception) {
        lastMessage = new Message(exception.getMessage(), dateTimeManager.getCurrent());

        throw exception;
    }

    public Message getLastMessage() {
        return lastMessage;
    }
}
