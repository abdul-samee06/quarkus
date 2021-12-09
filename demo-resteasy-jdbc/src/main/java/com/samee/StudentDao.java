package com.samee;
import java.util.List;


public interface StudentDao {
    
    public List<Student> getAllStudents();
    public Student getStudentById(Integer id);
    public Integer addStudent(Integer id, String name, String email);
    public Integer deleteStudent(Integer id);
    public Integer updateStudent(Integer id, String name, String email);

}
