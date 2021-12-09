package com.samee;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import io.smallrye.mutiny.Uni;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Streaming streaming = new Streaming("/home/bahl/Desktop/Abdul Samee/demo-reactive-blocking-nonblocking/src/main/java/com/samee/Data.txt");
        streaming.imperative();
        return "Hello RESTEasy";
    }

    @GET
    @Path("file")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> fileReader() {
        System.out.println("Started and Reading the file");

        Streaming streaming = new Streaming("/home/bahl/Desktop/Abdul Samee/demo-reactive-blocking-nonblocking/src/main/java/com/samee/Data.txt");
        // streaming.imperative();

        Uni.createFrom().item(streaming)
        .subscribe().with((item)->streaming.imperative());

        System.out.println("File Read Successfully");
        return Uni.createFrom().item("Imperative file reading Completed");

    }

    @GET
    @Path("reactive")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> reactive() {
        System.out.println("Started reading the file..................");
        Streaming streaming = new Streaming("/home/bahl/Desktop/Abdul Samee/demo-reactive-blocking-nonblocking/src/main/java/com/samee/Data.txt");
        streaming.reactive();
        System.out.println("Finished reading the file..................");
        System.out.println("Hello WOrld");
        return Uni.createFrom().item("Reactive file reading completed");
    }
}