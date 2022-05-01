/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chooselanguage;

import java.awt.event.*;
import user.UserModel;

/**
 *
 * @author mikjakbiak
 */
public class ChooseLanguageController {
    ChooseLanguageView theView;
    UserModel theModel;
    
    public ChooseLanguageController(ChooseLanguageView _theView, UserModel _theModel) {
        theView = _theView;
        theModel = _theModel;
        
        theView.setLanguageSelectListener(new LanguageSelectListener());
    }
    
    class LanguageSelectListener implements ActionListener{
        @Override
        public void actionPerformed(final ActionEvent e) {
            String language = e.getActionCommand();

            theModel.chooseLanguage(language);
        }
    }
}
