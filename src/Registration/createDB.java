
package sofdevgrp;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


public class createDB {
    public static void main(String[] args) {
        Connect connect = new Connect();
    }
}

class Connect {

    private String urlSQLite;
    private Driver driverSQLite;
    private Connection conSQLite;

    public Connect() {
        urlSQLite = "jdbc:sqlite:Registration.db";
        try {
            driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            //System.out.println("Driver for SQLite downloaded.");
        } catch (Exception e) {
            System.out.println("Problem with download driver for SQLite: " + e.getMessage());
        }
        try {
            conSQLite = DriverManager.getConnection(urlSQLite);
            //System.out.println("Connection to SQLite is done.");
        } catch (Exception e) {
            System.out.println("Problem with connection to SQLite: " + e.getMessage());
        }
        try {
            if (!conSQLite.isClosed()) {
                conSQLite.close();
                //System.out.println("Connection to SQLite closed.");
            }
        } catch (Exception e) {
            System.out.println("Problem with close connection of SQLite");
        }
    }
}
