package com.samee;

// import javax.enterprise.context.ApplicationScoped;
public class Student 
{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    Student()
    {
        
    }
}
