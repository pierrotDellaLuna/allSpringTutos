package ictcg.com.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//https://www.baeldung.com/rest-api-discoverability-with-spring

public class SingleResourceRetrievedDiscoverabilityListener implements ApplicationListener<ResourceCreated>{

	   @Override
	    public void onApplicationEvent(ResourceCreated resourceCreatedEvent){
	     
	 
	       HttpServletResponse response = resourceCreatedEvent.getResponse();
	       long idOfNewResource = resourceCreatedEvent.getIdOfNewResource();
	 
	       addLinkHeaderOnResourceCreation(response, idOfNewResource);
	   }
	   void addLinkHeaderOnResourceCreation
	     (HttpServletResponse response, long idOfNewResource){
	       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
	         path("/{idOfNewResource}").buildAndExpand(idOfNewResource).toUri();
	       response.setHeader("Location", uri.toASCIIString());
	    }

}
