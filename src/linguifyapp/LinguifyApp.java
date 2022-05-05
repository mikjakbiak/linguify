package linguifyapp;



import database.*;
import views.WelcomePage;

/**
 *
 * @author mikjakbiak w1782957
 */
public class LinguifyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreateDB connect = new CreateDB();
        CreateTables tables = new CreateTables();
        PopulateDB insertData = new PopulateDB();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.setVisible(true);
    }
    
}
