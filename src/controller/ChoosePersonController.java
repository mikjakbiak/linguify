/**
 * This class was made by Mathusan Nagalingam w1779171
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
    
    /**
     * The purpose of this function is to use redirect the user to the 
     * previous panel when the go back button is clicked
     * @param panel
     * @param previousJFrame 
     */
    public ChoosePersonController(JFrame panel, JFrame previousJFrame)
    {
        if (previousJFrame != null) 
        {
            panel.setVisible(false);
            previousJFrame.setVisible(true);
        }
    }
    
    /**
     * The purpose of this function is to redirect the user to the dialogue panel
     * 
     * Person id and sub context will be the principal variables that will be passed
     * 
     * @param panel
     * @param user
     * @param personID
     * @param subContextID 
     */
    public ChoosePersonController(JFrame panel, UserModel user, int personID, int subContextID)
    {
        dialogue dPanel = new dialogue(panel, user, personID, subContextID);
        panel.setVisible(false);
        dPanel.setVisible(true);
    }
}
