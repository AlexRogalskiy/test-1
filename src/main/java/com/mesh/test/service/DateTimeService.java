package com.mesh.test.service;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateTimeService {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private DateTimeService() {

    }

    public static String getCurrent() {
        return dtf.format(LocalDateTime.now());
    }

}