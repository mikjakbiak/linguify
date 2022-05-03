package controller;

import database.ConnectDB;
import java.awt.event.ActionEvent;
import java.sql.*;

public class loginController 
{
    loginController(ActionEvent evt) throws ClassNotFoundException 
    {          
//        Connection con = ConnectDB.getConnection();
//        Statement stmt = null;
//        
//        
//        try 
//        {
//            String sqlQuery = "SELECT * FROM User WHERE userEmail =?";
//            PreparedStatement pst = con.prepareStatement(sqlQuery);
//            pst.setString(1, emailField.getText());
//            
//            
//            
//            stmt = con.createStatement();
//            
//            
//            con.commit();
//        } catch (SQLException ex) {
//            System.err.println("SQLException: " + ex.getMessage());
//        } finally {
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    System.err.println("SQLException: " + e.getMessage());
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    System.err.println("SQLException: " + e.getMessage());
//                }
//            }
//        }            
    }    
}
