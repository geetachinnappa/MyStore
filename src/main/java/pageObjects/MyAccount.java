package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class MyAccount
{
    @FindBy (className = "info-account")
    public WebElement welcome;

    public MyAccount()
    {
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public String validateSignIn()
    {
       return welcome.getText();
    }

}
