/**
 * This class was made by Mathusan Nagalingam w1779171
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
import views.StudentPanel;
import views.Teacher;

/**
 *
 * @author mathu
 */
public class StudentProgressController 
{
    private String date;
    private String email;
    
    /**
     * The purpsoe of this controller constructor
     * 
     * is to display the barchart to the user by retrieving from the database
     * 
     * @param chartPanel
     * @param email
     * @param date 
     */
    public StudentProgressController(JPanel chartPanel, String email, String date)//, UserModel userModel
    {
        try
        {
            Connection con = ConnectDB.getConnection();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
            String sqlQuery = "SELECT levelContextId FROM UserLearnHistory WHERE userEmail =?";  //make sql query
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            
            int startingInt = 0;
            
            int userProgress = rs.getInt("levelContextId");
            
            dataset.setValue(userProgress, "Level", "A1");
            dataset.setValue(7, "Level", "A2");
            dataset.setValue(8, "Level", "B1");
            dataset.setValue(5, "Leve", "B2");
            JFreeChart chart = ChartFactory.createBarChart("Student Progress",
            "Achieved", "Level code", dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel panel = new ChartPanel(chart);
            chartPanel.removeAll();
            chartPanel.add(panel, BorderLayout.CENTER);
            chartPanel.validate();
            rs.close();
            con.close(); 
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
       
    }
}
