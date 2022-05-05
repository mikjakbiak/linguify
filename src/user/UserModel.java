package user;

/**
 *
 * @author mikjakbiak
 */
public class UserModel {

    //all the user information will be stored in the user model
    String userEmail;
    String userType;
    String chosenLanguage;
    int chosenLanguageLevelId;
    int chosenContextId;
    int chosenSubContextId;
    javax.swing.JFrame hubPanel;
    
    //when the user logs in, user model will store data about the userd etails for the current login session
    public void setEmail(String email) {
        this.userEmail = email;
    }
    public void setLanguage(String language) {
        chosenLanguage = language;
    }
    public void setType(String userType) {
        this.userType = userType;
    }
    public void setLanguageLevelId(int languageLevel) {
        chosenLanguageLevelId = languageLevel;
    }
    public void setContextId(int context) {
        chosenContextId = context;
    }
    public void setSubContextId(int subContext) {
        chosenSubContextId = subContext;
    }
    public void setHubPanel(javax.swing.JFrame hubPanel) {
        this.hubPanel = hubPanel;
    }

    public String getEmail() {
        return userEmail;
    }
    public String getType() {
        return userType;
    }
    public String getLanguage() {
        return chosenLanguage;
    }
    public int getLanguageLevel() {
        return chosenLanguageLevelId;
    }
    public int getContext() {
        return chosenContextId;
    }
    public int getSubContext() {
        return chosenSubContextId;
    }
    public javax.swing.JFrame getHubPanel() {
        return hubPanel;
    }
}
