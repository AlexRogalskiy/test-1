package com.mesh.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mesh.test.model.ResponseDTO;
import com.mesh.test.service.entity.Message;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class ExceptionService {
    private final DateTimeService dateTimeService;
    private Message lastMessage;

    ExceptionService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
        this.lastMessage = new Message("Сообщений об ошибках ещё не было", dateTimeService.getCurrent());
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String message) {
        lastMessage = new Message(message, dateTimeService.getCurrent());
    }

    public void securityResponse(HttpServletResponse httpServletResponse) throws IOException {
        String message = "Не найден header Authorization: Bearer <токен> у запроса";
        ResponseDTO response = new ResponseDTO().msg(message);

        httpServletResponse.setStatus(401);
        OutputStream out = httpServletResponse.getOutputStream();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, response);
        out.flush();

        setLastMessage(message);
    }
}
