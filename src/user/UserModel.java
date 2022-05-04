/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author mikjakbiak
 */
public class UserModel {
    String email;
    String chosenLanguage;
    int chosenLanguageLevelId;
    int chosenContextId;
    int chosenSubContextId;

    public void setEmail(String email) {
        this.email = email;
    }
    public void setLanguage(String language){
        chosenLanguage = language;
    }
    public void setLanguageLevelId(int languageLevel){
        chosenLanguageLevelId = languageLevel;
    }
    public void setContextId(int context){
        chosenContextId = context;
    }
    public void setSubContextId(int subContext){
        chosenSubContextId = subContext;
    }

    public String getLanguage(){
        return chosenLanguage;
    }
    public int getLanguageLevel(){
        return chosenLanguageLevelId;
    }
    public int getContext(){
        return chosenContextId;
    }
    public int getSubContext(){
        return chosenSubContextId;
    }
}
