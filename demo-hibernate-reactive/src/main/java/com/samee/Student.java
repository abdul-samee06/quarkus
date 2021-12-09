package com.samee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;


@Entity
public class Student extends PanacheEntityBase {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
    
    @Column
    private String email;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
