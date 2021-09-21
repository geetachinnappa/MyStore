package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class HomePage
{
    @FindBy (linkText = "Sign in")
    public WebElement signIn;

    @FindBy (linkText = "Sign out")
    public WebElement signOut;


    public HomePage()
    {
        PageFactory.initElements(DriverFactory.driver, this);
    }


    public void clickSignInLink()
    {
        signIn.click();
    }


    public void clickSignOutLink()
    {
        signOut.click();
    }

}
