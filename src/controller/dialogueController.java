/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.ConnectDB;
import java.util.ArrayList;
import java.sql.*;
import user.UserModel;

/**
 *
 * @author NUR
 */
public class dialogueController {
    
    public ArrayList<String> fetchData(int personId, UserModel userModel) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;  // should be passed on from the previous 
        ResultSet rs = null;
        ArrayList<String> convLines =  new ArrayList<>();
    
         try 
            {
                stmt = con.createStatement();
                //if user exist brings the salt and salt+hash
                String sql = "SELECT * FROM Conversation WHERE personID ='" + personId +"'AND subContID ='" + userModel.getSubContext() +"'";
                rs = stmt.executeQuery(sql);
                
                
                while (rs.next()){
                    String convLine = rs.getString("convDesc");
                    convLines.add(convLine);
                    
                }
                
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
        return convLines;
    }
}
  