package com.samee;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.samee.model.Episodes;
import com.samee.model.TvSeries;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/tvseries")
public class TvSeriesResource {

    @Inject
    @RestClient
    TvSeriesServices service;

    @Inject
    @RestClient
    EpisodeServices episervices;

    List<TvSeries> tvSeries = new ArrayList<>();
    List<Episodes> episodes = new ArrayList<>();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title) {
        TvSeries tvSerie = service.get(title);
        System.out.println(tvSerie.toString());
        System.out.println("yooooooooooooooooooooooo!");
        episodes = episervices.get(tvSerie.getId());
        return Response.ok(episodes).build();
    }
}