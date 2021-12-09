package com.samee;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResouce {
    
    @Inject
    MovieProducer producer;

    @POST
    public Response send(Movie movie){
        producer.sentMovieToKafka(movie);
        return Response.ok(movie).build();
    }

}
