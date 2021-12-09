package com.samee;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.reactive.RestPath;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class StudentResource {

    
    @GET
    public Uni<List<Student>> getAllStudents(){
        return Student.listAll();
    }

    @GET
    @Path("/{id}")
    public Uni<Student> getStudentById(@RestPath Long id){
        return Student.findById(id);
    }

    @POST
    @Path("/add")
    public Uni<Response> addStudent(Student student){

        if(student.getName()==null || student.getId()!=null){
            throw new WebApplicationException("Please enter valid name and email");
        }

        return Panache.withTransaction(student::persist)
        .replaceWith(Response.ok(student).build());
    }

    @PUT
    @Path("/{id}")
    public Uni<Response> updateStudent(@RestPath Long id, Student updatedStudent){
       
        if(updatedStudent.getName() == null || updatedStudent.getEmail() == null || updatedStudent.getId()!=null){
            throw new WebApplicationException("Please Enter Valid Data");
        }

        return Panache
        .withTransaction(() -> Student.<Student> findById(id)
            .onItem().ifNotNull().invoke(
                student -> {student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                }
            )
        )
        .onItem().ifNotNull().transform(entity -> Response.ok(entity).build())
        .onItem().ifNull().continueWith(Response.ok().status(Status.NOT_FOUND)::build);

    }

   

    @DELETE
    @Path("{id}")
    public Uni<Response> deleteStudent(@RestPath Long id) {
        return Panache.withTransaction(() -> Student.deleteById(id))
                .map(deleted -> deleted
                        ? Response.ok(deleted).status(Status.NO_CONTENT).build()
                        : Response.ok(deleted).status(Status.NOT_FOUND).build());
    }

}