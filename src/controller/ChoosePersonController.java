/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JFrame;
import user.UserModel;
import views.dialogue;

/**
 *
 * @author mathu
 */
public class ChoosePersonController {
    
    public ChoosePersonController(JFrame panel, UserModel user, int personID, int subContextID)
    {
        dialogue dPanel = new dialogue(panel, user, personID, subContextID);
        panel.setVisible(false);
        dPanel.setVisible(true);
    }
}
