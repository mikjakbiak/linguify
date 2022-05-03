/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

/**
 *
 * @author mathu
 */
public class CreateTables {

    public static void main(String[] args) {
        createLangTbl();
        createLevelTbl();
        levelContextTbl();
        createTopicTbl();
        createSubTopicTbl();
        conversationTbl();
        personTbl();
        translationTbl();
        createUserTbl();
        userLogHistoryTbl();
        userLearnHistoryTbl();
    }

    private static void createTable(String table) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.execute(table);
            con.commit();
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

    private static void createUserTbl() {
        String userTbl;
        userTbl = "CREATE TABLE IF NOT EXISTS User\n"
                + "(\n"
                + "	userEmail  	    VARCHAR(100),\n"
                + "    \n"
                + "    userPw          VARCHAR(25) NOT NULL,\n"
                + "	userFName	    VARCHAR(20) NOT NULL,\n"
                + "	userLName	    VARCHAR(20) NOT NULL,\n"
                + "    userType        char(1)     NOT NULL,\n"
                + "    selectedLang    varchar(25),\n"
                + "    \n"
                + "	constraint 		u_ue_pk PRIMARY KEY (userEmail)\n"
                + ");";
        createTable(userTbl);
    }

    private static void createLevelTbl() {
        String levelTbl;
        levelTbl = "CREATE TABLE IF NOT EXISTS Level\n"
                + "(\n"
                + "	levelID  	    INTEGER,\n"
                + "    \n"
                + "	levelName	    VARCHAR(25) not null,\n"
                + "    \n"
                + "	constraint 		l_lid_pk PRIMARY KEY (levelID)\n"
                + ");";
        createTable(levelTbl);
    }

    private static void createLangTbl() {
        String langTbl;
        langTbl = "CREATE TABLE IF NOT EXISTS Language\n"
                + "(\n"
                + "	languageName	    VARCHAR(25) ,\n"
                + "     languageDesc        VARCHAR (50),   \n"
                + "	constraint 	    l_ln_pk PRIMARY KEY (languageName)\n"
                + ");";
        createTable(langTbl);
    }

    private static void createTopicTbl() {
        String topicTbl;
        topicTbl = "CREATE TABLE IF NOT EXISTS Context\n"
                + "(\n"
                + "	contextID  	    INTEGER,\n"
                + "    \n"
                + "	contextDesc	    VARCHAR(100) not null,\n"
                + "    \n"
                + "	constraint 		c_cid_pk PRIMARY KEY (contextID)\n"
                + ");";
        createTable(topicTbl);
    }

    private static void levelContextTbl() {
        String levelContextTbl;
        levelContextTbl = "CREATE TABLE IF NOT EXISTS LevelContext\n"
                + "(\n"
                + "    levelContextId                  INTEGER,\n"
                + "    \n"
                + "    contextID                       INTEGER NOT NULL,\n"
                + "    levelID                         INTEGER NOT NULL,\n"
                + "    \n"
                + "    constraint      lcid_lc_pk      PRIMARY KEY(levelContextId),\n"
                + "    constraint      cid_lc_fk       FOREIGN KEY(contextID) references Context (contextID),\n"
                + "    constraint      lid_lc_fk       FOREIGN KEY(levelID)   references Level(levelID)\n"
                + ");";
        createTable(levelContextTbl);
    }

    private static void createSubTopicTbl() {
        String subTopicTable;
        subTopicTable = "CREATE TABLE IF NOT EXISTS SubContext\n"
                + "(\n"
                + "    subContID           INTEGER,\n"
                + "    \n"
                + "    subContDesc         VARCHAR(100) NOT NULL,\n"
                + "    grammarStructure    VARCHAR(100) NOT NULL,\n"
                + "    keyVocab            VARCHAR(100) NOT NULL,\n"
                + "    \n"
                + "    levelContextId      INTEGER NOT NULL,\n"
                + "    \n"
                + "    constraint scid_sc_pk       PRIMARY KEY(subContID),\n"
                + "    constraint lcid_sc_fk       FOREIGN KEY(levelContextId) references LevelContext (levelContextId)\n"
                + ");";
        createTable(subTopicTable);
    }

    private static void conversationTbl() {
        String conversationTbl;
        conversationTbl = "CREATE TABLE IF NOT EXISTS Conversation\n"
                + "(\n"
                + "    convID      INTEGER,\n"
                + "    \n"
                + "    convDesc    VARCHAR(100) NOT NULL,\n"
                + "    \n"
                + "    personID    INTEGER NOT NULL,\n"
                + "    subContID   INTEGER NOT NULL,\n"
                + "    \n"
                + "    constraint cid_c_pk     PRIMARY KEY(convID),\n"
                + "    constraint pid_c_fk     FOREIGN KEY(personID) references Person (personID)\n"
                + "    constraint scid_c_fk    FOREIGN KEY(subContID) references SubContext(subContID)\n"
                + ");";
        createTable(conversationTbl);
    }

    private static void personTbl() {
        String personTbl;
        personTbl = "CREATE TABLE IF NOT EXISTS Person\n"
                + "(\n"
                + "    personID    INTEGER,\n"
                + "    \n"
                + "    personDesc  VARCHAR(20) NOT NULL,\n"
                + "    \n"
                + "    constraint pid_p_pk PRIMARY KEY(personID)\n"
                + ");";
        createTable(personTbl);
    }

    private static void translationTbl() {
        String translationTbl;
        translationTbl = "CREATE TABLE IF NOT EXISTS Translation \n"
                + "(\n"
                + "    translationId           INTEGER,\n"
                + "    \n"
                + "    translatedWord          VARCHAR(500) NOT NULL,\n"
                + "    languageTranslated      VARCHAR (500) NOT NULL,\n"
                + "    \n"
                + "    convID                  INTEGER NOT NULL,\n"
                + "    languageName                    VARCHAR(25) NOT NULL,\n"
                + "    \n"
                + "    constraint tid_t_pk     PRIMARY KEY(translationId),\n"
                + "    constraint cid_t_fk     FOREIGN KEY(convID) references Conversation(convID),\n"
                + "    constraint ln_t_fk      FOREIGN KEY(languageName) references Language(languageName)\n"
                + ");";
        createTable(translationTbl);
    }

    private static void userLogHistoryTbl() {
        String userLogHistoryTbl;//cancella il db e ritesta
        userLogHistoryTbl = "CREATE TABLE IF NOT EXISTS UserLogHistory\n"
                + "(\n"
                + "    userLogId           INTEGER AUTO_INCREMENT,\n"
                + "    \n"
                + "    userEmail           VARCHAR(100) NOT NULL,\n"
                + "    \n"
                + "    loginDateTime       DATETIME NOT NULL,\n"
                + "    \n"
                + "    constraint ulid_ulh_pk PRIMARY KEY(userLogId),\n"
                + "    constraint ue_ulh_fk  FOREIGN KEY(userEmail) references User(userEmail)\n"
                + ");";
        createTable(userLogHistoryTbl);
    }

    private static void userLearnHistoryTbl() {
        String userLearnHistoryTbl;
        userLearnHistoryTbl = "CREATE TABLE IF NOT EXISTS UserLearnHistory\n"
                + "(\n"
                + "    userLearnHistID     INTEGER AUTO_INCREMENT,\n"
                + "    \n"
                + "    completedLvl        CHAR(1) NOT NULL,\n"
                + "    numOfTimeLevelCompl INTEGER NOT NULL,\n"
                + "    \n"
                + "    levelContextId      INTEGER NOT NULL,\n"
                + "    userEmail           VARCHAR(100) NOT NULL,\n"
                + "    subContextID        INTEGER NOT NULL,\n"
                + "    courseStatus        VARCHAR(20),\n"
                + "    languageName        VARCHAR(25) NOT NULL,\n"
                + "    date_time           DATETIME NOT NULL,\n"
                + "    \n"
                + "    constraint ulid_ulh_pk PRIMARY KEY(userLearnHistID),\n"
                + "    constraint lcid_ulh_fk FOREIGN KEY(levelContextId) references LevelContext(levelContextId),\n"
                + "    constraint ue_ulh_fk    FOREIGN KEY(userEmail) references User(userEmail),\n"
                + "    constraint scid_ulh_fk  FOREIGN KEY(subContextID) references SubContext(subContID),\n"
                + "    constraint ln_ulh_fk    FOREIGN KEY(languageName) references Language(languageName) \n"
                + ");";
        createTable(userLearnHistoryTbl);
    }

}
