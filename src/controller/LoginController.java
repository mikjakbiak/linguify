/**
 * This class was made by Mathusan Nagalingam w1779171
 */
package controller;

import database.ConnectDB;

import encryption.PasswordUtils1;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class LoginController {
    
    public LoginController(ActionEvent evt, JTextField emailField, JPasswordField pwField)
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        if(emailField.getText().equals("") || (pwField.getText().equals("")))
        {
            JOptionPane.showMessageDialog(null, "Please fill the form");
        }
        else
        {
            try 
            {
                stmt = con.createStatement();
                //if user exist brings the salt and salt+hash
                String sql = "SELECT encryptedKey, encryptedPw FROM User WHERE userEmail ='" + emailField.getText() +"'";
                rs = stmt.executeQuery(sql);
                
                boolean passwordMatch = PasswordUtils1.verifyUserPassword(pwField.getText(),rs.getString("encryptedPw"),rs.getString("encryptedKey"));

                if (passwordMatch)
                {
                    rs.close();
                    stmt.close();
                    con.close();
                    JOptionPane.showMessageDialog(null, "Login successful");
                    
                    
                    //userModel.setEmail(emailField.getText());
                    userLog(emailField);
                    
                    //store the email somewhere
                }
                else
                {
                    if(emailField.getText().equals("") || (pwField.getText().equals("")))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill the form");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Password");
                    }
                    rs.close();
                    stmt.close();
                    con.close();
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

            pst.setString(1, emailField.getText().trim());

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

