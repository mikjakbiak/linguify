/**
 * This class was made by Mathusan Nagalingam w1779171
 */
package database;

import java.sql.*;
import java.util.*;

//class CreateDB {
//
//    public static void main(String[] args) {
//        Connect connect = new Connect();
//    }
//}

public class CreateDB {

    private String urlSQLite;
    private Driver driverSQLite;
    private Connection con;

    public CreateDB() {
        urlSQLite = "jdbc:sqlite:linguify.db";
        try {
            driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            //System.out.println("Driver for SQLite downloaded.");
        } catch (Exception e) {
            //System.out.println("Problem with download driver for SQLite: " + e.getMessage());
        }
        try {
            con = DriverManager.getConnection(urlSQLite);
            //System.out.println("Connection to SQLite is done.");
        } catch (Exception e) {
            //System.out.println("Problem with connection to SQLite: " + e.getMessage());
        }
        try {
            if (!con.isClosed()) {
                con.close();
                //System.out.println("Connection to SQLite closed.");
            }
        } catch (Exception e) {
            //System.out.println("Problem with close connection of SQLite");
        }
    }
}
