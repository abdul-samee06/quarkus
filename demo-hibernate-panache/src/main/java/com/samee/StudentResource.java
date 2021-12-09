package com.samee;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @Inject
    StudentRepository sr;

    @GET
    public List<Student> getAllStudents(){
        return sr.listAll();
    }

    @GET
    @Path("/{id}")
    public Student getById(@PathParam("id") Long id){
        return sr.findById(id);
    }
    
    @POST
    @Transactional
    @Path("/add")
    public Response create(Student student){
        sr.persist(student);
        return Response.created(URI.create("/students/"+student.getId())).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") Long id, Student student){
        System.out.println(id);
        System.out.println(student.toString());
        Student student1 = sr.findById(id);
        if (student1 == null)
            throw new WebApplicationException("User doesn't exist!", 404);
        System.out.println("Student"+ student1.getEmail());
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());

        return Response.ok(student1).build();   
    }

    @Transactional
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Student student = sr.findById(id);
        if (student == null)
            throw new WebApplicationException("User does not exist!", 404);
        sr.delete(student);
        return Response.status(204).build();
    }

}