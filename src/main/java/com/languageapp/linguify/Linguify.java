package com.languageapp.linguify;

import com.languageapp.linguify.ChooseLanguage.ChooseLanguageView;
import javax.swing.JFrame;

/**
 *
 * @author mikjakbiak
 */
public class Linguify {

    public static void main(String[] args) {
        final JFrame frame = new ChooseLanguageView();
//        ChooseLanguageView chooseLanguageView = new ChooseLanguageView();
//
//        frame.setContentPane(chooseLanguageView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 573);
        frame.setVisible(true);
    }
}
