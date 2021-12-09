package com.samee;

import javax.enterprise.context.ApplicationScoped;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<Student>{
    
    

}
