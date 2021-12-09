package com.samee;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
public class StudentResource {
    @Inject
    StudentDaoImpl studentDao;
    List<Student> studentsList = new ArrayList<>();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> get()  {
        return studentDao.getAllStudents();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Student getStudentById(@PathParam("id") Integer id){
        return studentDao.getStudentById(id);
    }

    @POST
    @Path("/add/{id}/{name}/{email}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addStudent(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("email") String email){
        int row = studentDao.addStudent(id, name, email);
        return Response.ok(row).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteStudent(@PathParam("id") Integer id){
        int row = studentDao.deleteStudent(id);
        return Response.ok(row).build();
    }

    @PUT
    @Path("/update/{id}/{name}/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateStudent(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("email") String email){
        int row = studentDao.updateStudent(id, name, email);
        return Response.ok(row).build();
    }



}