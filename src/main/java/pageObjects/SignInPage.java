package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class SignInPage
{
    @FindBy (id = "email")
    public WebElement eMail;

    @FindBy (id = "passwd")
    public WebElement password;

    @FindBy (id = "SubmitLogin")
    public WebElement signInButton;

    @FindBy (xpath = "(//div[contains(@class,'alert-danger')])[1]")
    public WebElement signinError;

    @FindBy (id = "create_account_error")
    public WebElement createAccountError;

    @FindBy (id = "email_create")
    public WebElement createEmail;

    @FindBy (id = "SubmitCreate")
    public WebElement submitCreate;

    @FindBy (id = "create_account_error")
    public WebElement createErrorMsg;


    public SignInPage()
    {
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public void setEmail(String email)
    {
        eMail.sendKeys(email);
    }

    public void setPassword(String pwd)
    {
        password.sendKeys(pwd);
    }

    public void clickSigninButton()
    {
        signInButton.click();
    }

    public String getError()
    {
        if(createAccountError.isDisplayed())
        {
            return createAccountError.getText();
        }
        else if(signinError.isDisplayed())
        {
            return signinError.getText();
        }
        else
            return  "no Error";
    }

    public void enterEMail(String email)
    {
        createEmail.sendKeys(email);
    }

    public void clickCreateAnAccount()
    {
        submitCreate.click();
    }

    public String getErrorMessage()
    {
        return createErrorMsg.getText();
    }
}
