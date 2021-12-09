package com.samee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

@ApplicationScoped
public class StudentDaoImpl implements StudentDao {
    Logger logger = Logger.getLogger(this.getClass());
    @Inject
    DBConnection connectionProvider;

    @Override
    public List<Student> getAllStudents() {

        logger.info("gettting all students.");
        List<Student> studentsList = new ArrayList<>();
        try {
            Connection con = connectionProvider.makeConnection();
            if (con != null) {
                System.out.println("conection created with the database.");
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select * from student");
            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setEmail(rs.getString(3));
                studentsList.add(st);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return studentsList;

    }

    @Override
    public Integer addStudent(Integer id, String name, String email) {
        Integer row=0;
        try {
            Connection con = connectionProvider.makeConnection();
            PreparedStatement stmt = con.prepareStatement("Insert into student (id, name, email) values (?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);

            row =stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;

    }

    @Override
    public Integer deleteStudent(Integer id) {
        Integer row=0;
        try {
            Connection con = connectionProvider.makeConnection();
            PreparedStatement stmt = con.prepareStatement("delete from student where id=?");
            stmt.setInt(1, id);
            row =stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;

    }

    @Override
    public Integer updateStudent(Integer id, String name, String email) {
        Integer row=0;
        try {
            Connection con = connectionProvider.makeConnection();
            PreparedStatement stmt = con.prepareStatement("update student set name=?, email=? where id=?");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            row =stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;

    }

    @Override
    public Student getStudentById(Integer id) {
        Student st=new Student();
        try {
            Connection con = connectionProvider.makeConnection();
            PreparedStatement stmt = con.prepareStatement("select * from student where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                st.setId(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setEmail(rs.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return st;
    }

}
