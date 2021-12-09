package com.samee;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.samee.model.Episodes;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface EpisodeServices {

    @GET
    @Path("{id}/episodes")
    List<Episodes> get(@PathParam("id") long id);
    

}
