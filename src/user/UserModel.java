package user;

/**
 *
 * @author mikjakbiak
 */
public class UserModel {
    String chosenLanguage;
    String userEmail;
    String userType;
    //all the user information will be stored in the user model
    
    //when the user logs in, user model will store data about the userd etails for the current login session
    public void chooseLanguage(String language){
        chosenLanguage = language;
        //userEmail = email;
    }
    
    public void setType(String userType)
    {
        this.userType = userType;
    }
    
    public String getType()
    {
        return userType;
    }
    
    
    public void setEmail(String email)
    {
        userEmail = email;
    }
    
    public String getEmail()
    {
        return userEmail;
    }
    
    
}
