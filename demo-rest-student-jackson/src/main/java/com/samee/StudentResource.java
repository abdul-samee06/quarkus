package com.samee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
// import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/json1")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

//    @Inject
   Student student;
   List <Student>students=new ArrayList<>();
   
   
   @GET
   public Response getAllStudents(){
    return Response.ok(students).build();
   }

   @POST
   @Path("/add")
   public Response addStudent(Student student){

       students.add(student);
       return Response.ok(students).build();
   }

   @DELETE
   @Path("/delete/{id}")
   public Response removeStudent(@PathParam("id") Integer id){
       Iterator<Student> itr = students.iterator();
       while(itr.hasNext()){
            Student remStu = itr.next();
            if(remStu.getId().equals(id)){
                itr.remove();
            }
       }
       return Response.ok(students).build();
       
   }

   @PUT
   @Path("/update/{id}")
   public Response updateStudent(@PathParam("id") Integer id,Student updatedStudent){
    
    Iterator<Student> itr = students.iterator();
       while(itr.hasNext()){
            Student remStu = itr.next();
            if(remStu.getId().equals(id)){
                remStu.setName(updatedStudent.getName());
            }
       }
    return Response.ok(students).build();
   }

   
   
   



}