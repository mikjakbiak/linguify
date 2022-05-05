/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.ConnectDB;
import encryption.PasswordUtils1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import user.UserModel;
import views.StudentPanel;
import views.Teacher;

/**
 *
 * @author shefi
 */
public class RegistrationController {
    
    public RegistrationController(JTextField Fn, JTextField Ln, JTextField Em, JPasswordField Pw, ButtonGroup Bg, JRadioButton Srbtn, JRadioButton Trbtn, JFrame panel) throws SQLException 
    {
        try 
        {
            Connection con = ConnectDB.getConnection();
            String type = "";

            if (Srbtn.isSelected()) {
                type = "S";
            } else if (Trbtn.isSelected()) {
                type = "T";
            }

            if (Em.getText().length() == 0 || Pw.getText().length() == 0 || Fn.getText().length() == 0 || Ln.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please make sure all fields are filled in.");
            } else 
            {
                JOptionPane.showMessageDialog(null, "registration complete.");
                
                String myPassword = Pw.getText(); //take the password from thee PasswordTextField();

                // Generate Salt. The generated value can be stored in DB. 
                String salt = PasswordUtils1.getSalt(30);

                // Protect user's password. The generated value can be stored in DB.
                String mySecurePassword = PasswordUtils1.generateSecurePassword(myPassword, salt);

                String query = "INSERT INTO User (userEmail, userPw, userFName, userLName, userType, encryptedKey, encryptedPw, selectedLang) "
                        + "VALUES(?, NULL, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, Em.getText());
                pst.setString(2, Fn.getText());
                pst.setString(3, Ln.getText());
                pst.setString(4, type);
                pst.setString(5, salt);
                pst.setString(6, mySecurePassword);
                pst.setString(7, "");
                
                UserModel user = new UserModel();
                user.setEmail(Em.getText());
                user.setType(type);
                java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                
                pst.executeUpdate();
                pst.close();
                switch(type)
                {
                    case "S":
                        StudentPanel sp = new StudentPanel(user, date.toString(),user.getEmail());
                        panel.setVisible(false);
                        sp.setVisible(true);
                        break;

                    case "T":
                        Teacher tp = new Teacher(user,date.toString(), user.getEmail());
                        panel.setVisible(false);
                        tp.setVisible(true);
                        break;
                }
            }
            con.commit();
            con.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
}
