package controller;

import database.ConnectDB;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginController 
{
    loginController(ActionEvent evt) throws ClassNotFoundException 
    {          
 
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        
        String sqlQuery = "SELECT * FROM User WHERE userEmail =?";
        ///////
        try {
            stmt = con.createStatement();
            ResultSet executeQuery = stmt.executeQuery(sqlQuery);
            
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
