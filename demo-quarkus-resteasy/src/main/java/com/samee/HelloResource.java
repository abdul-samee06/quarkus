package com.samee;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;




@Path("/hello")
public class HelloResource {

    @Inject
    GreetingServices service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello sameee";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/sami")
    public String hi()
    {
        return "sameeeee";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{id}")
    public String greeting(@PathParam("id") String name){

       return service.greeting(name);

    }
}