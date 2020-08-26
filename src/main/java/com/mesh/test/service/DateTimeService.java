package com.mesh.test.service;

import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Service
public class DateTimeService {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public String getCurrent() {
        return dtf.format(LocalDateTime.now());
    }

}