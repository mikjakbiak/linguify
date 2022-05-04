package controller;

import database.ConnectDB;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author mathu
 */
public class LoginController {
    
    public LoginController(ActionEvent evt, JTextField emailField, JPasswordField pwField)
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        try 
        {
            String sqlQuery = "SELECT * FROM User WHERE userEmail =? AND userPw =?" ;
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            pst.setString(1, emailField.getText());
            pst.setString(2, pwField.getText());
            
            rs = pst.executeQuery();
            
            if (rs.next())
            {
                rs.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Login successful");
                userLog(emailField);
//                ChoosePersonGUI next = new ChoosePersonGUI();
//                this.setVisible(false);
//                next.setVisible(true);
            }
            else
            {
                rs.close();
                con.close();
                if(emailField.getText().equals("") || (pwField.getText().equals("")))
                {
                    JOptionPane.showMessageDialog(null, "Please fill the form");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }
                
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
    }
    
    private void userLog(JTextField emailField)
    {

        try
        {
            Connection con = ConnectDB.getConnection();
            Statement stmt = null;
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            
            String query = "INSERT INTO UserLogHistory (userEmail, loginDateTime)"
                + " VALUES (?,?);";
   
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, emailField.getText());
            pst.setString(2, date.toString());
            
            pst.executeUpdate();
            System.out.println("log history test " + date);
            
            pst.close();
            con.close();

        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
    }
}
