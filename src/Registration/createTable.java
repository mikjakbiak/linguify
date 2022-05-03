
package sofdevgrp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class createTable {
    public static void main(String[] args) {
        Connection con = connectDB.getConnection();
        Statement stmt = null;
        String createString;
        createString = "CREATE TABLE if not exists Users (\n"
                + "            userID     INTEGER     PRIMARY KEY,\n"
                + "            firstName  VARCHAR (15),\n"
                + "            lastName   VARCHAR (15),\n"
                + "            Email  VARCHAR (30),\n"
                + "            Password  VARCHAR (20),\n"
                + "            Type  VARCHAR (1)\n" + ") ;";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }
}