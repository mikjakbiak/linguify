/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linguifyapp;

import user.UserModel;
import views.LoginGUI;

/**
 *
 * @author mikjakbiak
 */
public class LinguifyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserModel userModel = new UserModel();
        LoginGUI loginGUI = new LoginGUI(userModel);
        loginGUI.setVisible(true);
    }
    
}
