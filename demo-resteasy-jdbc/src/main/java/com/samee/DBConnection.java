package com.samee;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@ApplicationScoped
public class DBConnection {
    Logger logger = Logger.getLogger(this.getClass());
    @Inject
    @DataSource("test-db")
    AgroalDataSource dataSource;

    public DBConnection() {
    }

    public Connection makeConnection() {
        logger.info("getting connection with database..");
        Connection con = null;
        if (con == null) {
            try {
                System.out.println("Connection is null creating the connection ...");
                con = dataSource.getConnection();
                if (con != null) {
                    System.out.println("Connection created .");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;

    }

}
