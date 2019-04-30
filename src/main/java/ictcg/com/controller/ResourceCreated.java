package ictcg.com.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

//https://www.baeldung.com/rest-api-discoverability-with-spring

public class ResourceCreated extends ApplicationEvent {
    private HttpServletResponse response;
    private long idOfNewResource;
 
    public ResourceCreated(Object source, 
      HttpServletResponse response, long idOfNewResource) {
        super(source);
 
        this.response = response;
        this.idOfNewResource = idOfNewResource;
    }
 
    public HttpServletResponse getResponse() {
        return response;
    }
    public long getIdOfNewResource() {
        return idOfNewResource;
    }
}
