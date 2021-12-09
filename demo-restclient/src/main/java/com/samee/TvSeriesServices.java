package com.samee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.samee.model.TvSeries;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/singlesearch/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface TvSeriesServices {

    @GET
    @Path("/shows")
    TvSeries get(@QueryParam("q") String title);
    
}
