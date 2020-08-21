package com.mesh.test.webapi;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
class WebApiConfig extends ResourceConfig {

    public WebApiConfig() {
        init();
    }

    private void init() {
        packages("com.mesh.test.webapi");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}