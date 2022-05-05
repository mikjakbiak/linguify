/**
 * This class was made by Mathusan Nagalingam w1779171
 */
package controller;

import database.ConnectDB;

import encryption.PasswordUtils1;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import user.UserModel;
import views.StudentPanel;
import views.Teacher;


public class LoginController {
    
    public LoginController(ActionEvent evt, JFrame panel, JTextField emailField)
    {
        if(!emailField.getText().equals(""))
            JOptionPane.showMessageDialog(panel, "You have successfully sent a request to the admin to reset your password!");
        else
             JOptionPane.showMessageDialog(panel, "Enter a valid email!");
    }
    
    public LoginController(ActionEvent evt, JTextField emailField, JPasswordField pwField, UserModel userModel, JFrame panel)
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
                String sql = "SELECT encryptedKey, encryptedPw, userType FROM User WHERE userEmail ='" + emailField.getText() +"'";
                rs = stmt.executeQuery(sql);
                
                boolean passwordMatch = PasswordUtils1.verifyUserPassword(pwField.getText(),rs.getString("encryptedPw"),rs.getString("encryptedKey"));



                if (passwordMatch)
                {
                    String type = rs.getString("userType");
                    userModel.setType(type);
                    System.out.println("TYPE OF USER IS: " + userModel.getType());
                    rs.close();
                    stmt.close();
                    con.close();
                    JOptionPane.showMessageDialog(null, "Login successful");
                    
                    
                    userModel.setEmail(emailField.getText());
                    String date = userLog(emailField);
                    
                    switch(userModel.getType())
                    {
                        case "S":
                            StudentPanel sp = new StudentPanel(userModel, date, emailField.getText());
                            panel.setVisible(false);
                            sp.setVisible(true);
                            break;
                        
                        case "T":
                            Teacher tp = new Teacher(userModel,date, emailField.getText());
                            panel.setVisible(false);
                            tp.setVisible(true);
                            break;
                    }
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
    
    private String userLog(JTextField emailField)
    {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try
        {
            Connection con = ConnectDB.getConnection();
            Statement stmt = null;
            
            
            String query = "INSERT INTO UserLogHistory (userEmail, loginDateTime)"
                + " VALUES (?,?);";
   
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, emailField.getText().trim());

            pst.setString(2, date.toString());
            
            pst.executeUpdate();
            System.out.println("log history test " + date);
            
            pst.close();
            con.close();
            return date.toString();
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        return date.toString();
    }
}
