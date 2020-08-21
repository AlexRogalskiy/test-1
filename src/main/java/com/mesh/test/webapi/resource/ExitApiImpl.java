package com.mesh.test.webapi.resource;

import com.mesh.test.model.ResponseDTO;
import com.mesh.test.webapi.ExitApi;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class ExitApiImpl implements ExitApi {
    ApplicationContext appContext;

    public ExitApiImpl(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @Override
    public Response getExit() {
        SpringApplication.exit(appContext, () -> 0);

        return Response.ok()
                .entity(new ResponseDTO().msg("Приложение успешно завершило свою работу"))
                .build();
    }
}
