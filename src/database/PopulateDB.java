
package database;

import java.io.*;
import java.sql.*;
import java.util.*;

public class PopulateDB 
{
    public static void main(String[] args) 
    {
        //insertContext();
        insertConversation();
        //insertLanguage();
    }    
    
    private static void insertContext()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("C:\\Users\\mathu\\OneDrive\\Documenti\\NetbeansProjects\\Mathu\\linguify\\src\\database\\context.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            ArrayList list = new ArrayList();
            ArrayList IdChecker = new ArrayList();
            int count = 0;
            while ((strLine = br.readLine()) != null) {
                //System.out.println("list"+list);
                list.add(strLine);
                count++;
                //System.out.println(count);
            }
            
            Iterator itr;
            for (itr = list.iterator(); itr.hasNext();) {
                String str = itr.next().toString();
                String[] splitSt = str.split(",");
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    int contextID = Integer.parseInt(splitSt[0]);
                    String contextDesc = splitSt[1];
                    String sqlString = "INSERT INTO Context (contextID, contextDesc) VALUES \n"
                            + "(" + contextID + ",'" + contextDesc + "')";

                    con.setAutoCommit(false);
                    stmt = con.createStatement();
                    stmt.executeUpdate(sqlString);
                    stmt.close();
                    con.commit();
                } else {
                    System.out.println("duplicate record, with pk :" + splitSt[0]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }
    
    private static void insertConversation()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("C:\\Users\\mathu\\OneDrive\\Documenti\\NetbeansProjects\\Mathu\\linguify\\src\\database\\conversation.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            ArrayList list = new ArrayList();
            ArrayList IdChecker = new ArrayList();
            int count = 0;
            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
                count++;
            }
            Iterator itr;
            for (itr = list.iterator(); itr.hasNext();) {
                String str = itr.next().toString();
                String[] splitSt = str.split(",");
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    int convID = Integer.parseInt(splitSt[0]);
                    String convDesc = splitSt[1];
                    int personID = Integer.parseInt(splitSt[2]);
                    int subContID = Integer.parseInt(splitSt[3]);
                    String sqlString = "INSERT INTO Conversation (convID, convDesc, personID, subContID) VALUES \n"
                            + "(" + convID + ",'" + convDesc + "'," + personID + "," + subContID + ")";
                    con.setAutoCommit(false);
                    stmt = con.createStatement();
                    stmt.executeUpdate(sqlString);
                    stmt.close();
                    con.commit();
                } else {
                    System.out.println("duplicate record, with pk :" + splitSt[0]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }           
    }
    
     private static void insertLanguage()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("C:\\Users\\mathu\\OneDrive\\Documenti\\NetbeansProjects\\Mathu\\linguify\\src\\database\\language.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            ArrayList list = new ArrayList();
            ArrayList IdChecker = new ArrayList();
            int count = 0;
            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
                count++;
            }
            Iterator itr;
            for (itr = list.iterator(); itr.hasNext();) {
                String str = itr.next().toString();
                String[] splitSt = str.split(",");
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    String languageName = splitSt[0];
                    String langDesc = splitSt[1];

                    String sqlString = "INSERT INTO Language (languageName, languageDesc) VALUES \n"
                            + "('" + languageName + "','" + langDesc + "')";
                    con.setAutoCommit(false);
                    stmt = con.createStatement();
                    stmt.executeUpdate(sqlString);
                    stmt.close();
                    con.commit();
                } else {
                    System.out.println("duplicate record, with pk :" + splitSt[0]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }           
    }
}
