package com.mesh.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mesh.test.model.ResponseDTO;
import com.mesh.test.service.entity.Message;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

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

    public static void securityResponse(HttpServletResponse httpServletResponse) throws IOException {
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
