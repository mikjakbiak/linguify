/**
 * This class was made by Mathusan Nagalingam w1779171
 */
package database;

import java.io.*;
import java.sql.*;
import java.util.*;

public class PopulateDB 
{
    public static void main(String[] args) 
    {
        insertContext();
        insertConversation();
        insertLanguage();
        insertLevel();
        insertLevelContext();
        insertPerson();
        insertSubTopic();
        insertTrickyWord();
        insertUser();
    }    
    
    private static void insertContext()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/context.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
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
        }finally {
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
    
    private static void insertConversation()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/conversation.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
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
        }finally {
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
    
    private static void insertLanguage()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/language.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
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
        }finally {
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
    
    private static void insertLevel()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/level.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    int levelID = Integer.parseInt(splitSt[0]);
                    String levelDescription = splitSt[1];

                    String sqlString = "INSERT INTO Level (levelID, levelName) VALUES \n"
                            + "(" + levelID + ",'" + levelDescription + "')";
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
        }finally {
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
    
    
    private static void insertLevelContext()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/levelContext.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    int levelContextId = Integer.parseInt(splitSt[0]);
                    int contextID = Integer.parseInt(splitSt[1]);
                    int levelID = Integer.parseInt(splitSt[2]);
           
                    String sqlString = "INSERT INTO LevelContext (levelContextId, contextID, levelID) VALUES \n"
                            + "(" + levelContextId + "," + contextID + "," + levelID + ")";
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
        }finally {
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
    
    private static void insertPerson()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/person.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    int personID = Integer.parseInt(splitSt[0]);
                    String personDesc = splitSt[1];

                    String sqlString = "INSERT INTO Person (personID, personDesc) VALUES \n"
                            + "(" + personID + ",'" + personDesc + "')";
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
        }finally {
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
    
    private static void insertSubTopic()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/subContext.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    int subContID = Integer.parseInt(splitSt[0]);
                    String subContDesc = splitSt[1];
                    String grammarStructure = splitSt[2];
                    String keyVocab = splitSt[3];
                    int levelContextId = Integer.parseInt(splitSt[4]);
                    
                    String sqlString = "INSERT INTO SubContext (subContID, subContDesc, grammarStructure, keyVocab, levelContextId) VALUES \n"
                            + "(" + subContID + ",'" + subContDesc + "','" + grammarStructure + "','" + keyVocab + "'," + levelContextId + ")";
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
        }finally {
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
    
    private static void insertTrickyWord()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/trickyWord.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    int translationId = Integer.parseInt(splitSt[0]);
                    String translatedWord = splitSt[1];
                    String languageTranslated = splitSt[2];
                    int convID = Integer.parseInt(splitSt[3]);
                    String levelContextId = splitSt[4];
                    
                    String sqlString = "INSERT INTO Translation (translationId, translatedWord, languageTranslated, convID, languageName) VALUES \n"
                            + "(" + translationId + ",'" + translatedWord + "','" + languageTranslated + "'," + convID + ",'" + levelContextId + "')";
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
        }finally {
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

    private static void insertUser()
    {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try 
        {
            FileInputStream fstream = new FileInputStream("src/database/users.csv");
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
                String[] splitSt = str.split("(?<!\\\\),");
                for (int i = 0; i < splitSt.length; i++) {
                    splitSt[i] = splitSt[i].replace("\\,", ", ");
                }
                if (!IdChecker.contains(splitSt[0])) 
                {
                    IdChecker.add(splitSt[0]);
                    String userEmail = splitSt[0];
                    String userPw = splitSt[1];
                    String userFName = splitSt[2];
                    String userLName = splitSt[3];
                    char userType = splitSt[4].charAt(0);
                    String encryptedKey = splitSt[5];
                    String encryptedPw = splitSt[6];
                    String selectedLang = splitSt[7];
                    
                    String sqlString = "INSERT INTO User(userEmail, userPw, userFName, userLName, userType, encryptedKey, encryptedPw,selectedLang) VALUES (?,NULL,?,?,?,?,?,?);";
                   
                    con.setAutoCommit(false);
                                     
                    PreparedStatement pst = con.prepareStatement(sqlString);
                    pst.setString(1, splitSt[0]);
                    pst.setString(2, splitSt[2]);
                    pst.setString(3, splitSt[3]);
                    pst.setString(4, splitSt[4]);
                    pst.setString(5, splitSt[5]);
                    pst.setString(6, splitSt[6]);
                    pst.setString(7, splitSt[7]);
            
                    pst.executeUpdate();
                    pst.close();
                    
                    con.commit();
                } else {
                    System.out.println("duplicate record, with pk :" + splitSt[0]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
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
