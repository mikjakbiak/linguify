/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JTextArea;
import user.UserModel;

/**
 *
 * @author NURCHI
 */
public class dialogueController {
    
    public dialogueController(JTextArea scriptLines,JButton scriptBck, JButton scriptNxt, JButton scriptFin, JButton keywordBtn, UserModel userModel){
    
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;  // should be passed on from the previous 
        ResultSet rs = null;
        
       
        String sqlQury = "SELECT * FROM conversation WHERE context ='" ;
    
    
    }
}
    

