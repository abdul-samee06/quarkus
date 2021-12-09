package com.samee;

import java.sql.Connection;

import javax.inject.Inject;

import io.agroal.api.AgroalDataSource;

public class Test {
    @Inject
    AgroalDataSource dataSource;

    public static void main(String[] args) {
        Test t = new Test();
        try {
            Connection connection = t.dataSource.getConnection();
            if (connection != null) {
                System.out.println("COnnection created .");
            } else {
                System.out.println("failed to create the connection ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
