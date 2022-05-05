/**
 * This class was made by Mathusan Nagalingam w1779171
 */
package database;

import java.sql.*;

public class ConnectDB {
        public static Connection getConnection() 
    {
        try 
        {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:linguify.db"; // will create this database if it does not exist
            Connection con = DriverManager.getConnection(url);
                //JOptionPane.showMessageDialog(null, "Connection Established");
            return con;
        } 
        catch (Exception e) 
        {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
