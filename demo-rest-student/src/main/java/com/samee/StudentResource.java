package com.samee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
// import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello")

@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

//    @Inject
   Student student;
   List <Student>students=new ArrayList<>();
   
   
   @GET
   public String getAllStudents(){
    return new Gson().toJson(students);
   }

   @POST
   @Path("add/{id}/{name}")
   public String addStudent(@PathParam("id") Integer id, @PathParam("name") String name){

    // System.out.println(id);
    // System.out.println(name);
       student=new Student();
       student.setId(id);
       student.setName(name);
       students.add(student);
       return new Gson().toJson(students);
   }

   @DELETE
   @Path("/delete/{id}")
   public String removeStudent(@PathParam("id") Integer id){
       Iterator<Student> itr = students.iterator();
       while(itr.hasNext()){
            Student remStu = itr.next();
            if(remStu.getId().equals(id)){
                itr.remove();
            }
       }
       return new Gson().toJson(students);
       
   }

   @PUT
   @Path("/update/{id}/{name}")
   public String updateStudent(@PathParam("id") Integer id,@PathParam("name") String name){
    
    Iterator<Student> itr = students.iterator();
       while(itr.hasNext()){
            Student remStu = itr.next();
            if(remStu.getId().equals(id)){
                remStu.setName(name);
            }
       }
    return new Gson().toJson(students);
   }

   
   
   



}