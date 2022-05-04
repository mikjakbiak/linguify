/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author shefi
 */
public class RegistrationController {
    public RegistrationController(JTextField Fn, JTextField Ln, JTextField Em, JPasswordField Pw, ButtonGroup Bg, JRadioButton Srbtn, JRadioButton Trbtn) throws SQLException {
    try {
        
    
        Connection con = ConnectDB.getConnection();
        //Statement stmt = null;
        String type = "";
        

        if (Srbtn.isSelected())
        type = "S";
        else if (Trbtn.isSelected())
        type = "T";
        
        if (Em.getText().length() == 0 || Pw.getText().length() == 0 || Fn.getText().length() == 0 || Ln.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please make sure all fields are filled in.");
        } else {
            JOptionPane.showMessageDialog(null, "registration complete.");
        }

        String query = "INSERT INTO User (userEmail, userPw, userFName, userLName, userType, selectedLang) VALUES(?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, Em.getText());
            pst.setString(2, Pw.getText());
            pst.setString(3, Fn.getText());
            pst.setString(4, Ln.getText());
            pst.setString(5, type);
            pst.setString(6, "");
            
            pst.executeUpdate();
            
            pst.close();
            //stmt.close();
            con.close();
    }
      catch (SQLException ex)
        {
            System.out.println(ex);
        }      
        /*try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
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
        }*/
}
}
