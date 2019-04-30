package ictcg.com.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

//https://www.baeldung.com/rest-api-discoverability-with-spring

public class singleResourceRetrieved extends ApplicationEvent {

	 private HttpServletResponse response;
	 
	    public singleResourceRetrieved(Object source, HttpServletResponse response) {
	        super(source);
	 
	        this.response = response;
	    }
	 
	    public HttpServletResponse getResponse() {
	        return response;
	    }

}
