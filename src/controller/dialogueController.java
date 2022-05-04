/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author NURCHI
 */
public class dialogueController {
    
    Connection con = ConnectDB.getConnection();
    Statement stmt = null;  // should be passed on from the previous 
    ResultSet rs = null;
    
}
