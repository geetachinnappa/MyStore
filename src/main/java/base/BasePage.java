package base;

import pageObjects.CreateAccount;
import pageObjects.HomePage;
import pageObjects.MyAccount;
import pageObjects.SignInPage;
import utils.DriverFactory;
import utils.DriverUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class BasePage
{
    public static Properties prop;
    public static DriverUtils driverUtils;
    public static HomePage homePage;
    public static SignInPage signInPage;
    public static CreateAccount createAccount;
    public static MyAccount myAccount;


    public static void initPages()
    {
        prop = new Properties();

        driverUtils = new DriverUtils();
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccount = new CreateAccount();
        myAccount = new MyAccount();


        //loading properties file
        try
        {
            FileInputStream fs = new FileInputStream("src/main/java/config/data.properties");
            prop.load(fs);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
