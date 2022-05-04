/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.ConnectDB;
import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import user.UserModel;

/**
 *
 * @author mathu
 */
public class StudentProgressController 
{
    public StudentProgressController(JPanel chartPanel)//, UserModel userModel
    {
        try
        {
            Connection con = ConnectDB.getConnection();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
            String sqlQuery = "SELECT levelContextId FROM UserLearnHistory WHERE userEmail =?";
//            PreparedStatement pst = con.prepareStatement(sqlQuery);
//            pst.setString(1, userModel.getEmail());
//            
//            ResultSet rs = pst.executeQuery();
//            
//            if(rs.next())
//            {
//                
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "error");
//            }
            
            con.close();
            dataset.setValue(6, "Profit", "Jane");
            dataset.setValue(7, "Profit", "Tom");
            dataset.setValue(8, "Profit", "Jill");
            dataset.setValue(5, "Profit", "John");
            dataset.setValue(12, "Profit", "Fred");
            JFreeChart chart = ChartFactory.createBarChart("Student Progress",
            "Salesman", "Profit", dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel panel = new ChartPanel(chart);
            chartPanel.removeAll();
            chartPanel.add(panel, BorderLayout.CENTER);
            chartPanel.validate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
       
    }
}
