package com.mesh.test.service.entity;

public class Message {
    private final String msg;
    private final String created;

    public Message(String msg, String created) {
        this.msg = msg;
        this.created = created;
    }

    public String getMsg() {
        return msg;
    }

    public String getCreated() {
        return created;
    }
}
