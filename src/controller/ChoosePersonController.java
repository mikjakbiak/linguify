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
    
    public ChoosePersonController(JFrame panel, UserModel user, int personID, int subContextID)
    {
        dialogue dPanel = new dialogue(panel, user, personID, subContextID);
        panel.setVisible(false);
        dPanel.setVisible(true);
    }
}
