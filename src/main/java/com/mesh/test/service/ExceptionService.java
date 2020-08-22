package com.mesh.test.service;

import com.mesh.test.service.entity.Message;

public class ExceptionService {
    private static Message lastMessage = new Message(null, null);

    private ExceptionService() {

    }
    public static Message getLastMessage() {
        return lastMessage;
    }

    public static void setLastMessage(String message) {
        lastMessage = new Message(message, DateTimeService.getCurrent());
    }
}
