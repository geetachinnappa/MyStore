package steps;

import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class StepDefinitions
{
    String email;
    String password;

    WebDriverWait wait;

    @Given("user navigates to the webiste {string}")
    public void user_navigates_to_the_webiste(String url)
    {
        BasePage.driverUtils.navigateToUrl(url);

        Assertions.assertEquals(BasePage.prop.getProperty("homePageExpectedTitle"), BasePage.driverUtils.getTitle());
    }

    @When("user clicks on sign in link")
    public void user_clicks_on_sign_in_link()
    {
        BasePage.homePage.clickSignInLink();
        Assertions.assertEquals(BasePage.prop.getProperty("signInExpectedTitle"), BasePage.driverUtils.getTitle());
    }

    @When("user logs in through Sign In window by using UserEmail as {string} and Password as {string}")
    public void user_logs_in_through_sign_in_window_by_using_user_email_as_and_password_as(String userEmail, String userPassword)
    {
        this.email = userEmail;
        this.password = userPassword;

        BasePage.signInPage.setEmail(userEmail);
        BasePage.signInPage.setPassword(userPassword);

        BasePage.signInPage.clickSigninButton();

    }


    @Then("user should see the error message")
    public void user_should_see_the_error_message()
    {
        if(email.isEmpty()) //check if email is blank
        {
            Assertions.assertEquals(BasePage.prop.getProperty("blankEmail"),BasePage.signInPage.getError());
        }
        else if(!BasePage.driverUtils.checkEmailFormat(BasePage.prop.getProperty("emailFormat")))
        {
            Assertions.assertEquals(BasePage.prop.getProperty("invalidEMailAddress"),BasePage.signInPage.getError());
        }
        else if(password.isEmpty()) //check if password is blank
        {
            Assertions.assertEquals(BasePage.prop.getProperty("blankPassword"),BasePage.signInPage.getError());
        }
    }


    @Then("user is signed in successfully")
    public void user_is_signed_in_successfully()
    {
        Assertions.assertEquals(BasePage.prop.getProperty("myAccountExpectedTitle"), BasePage.driverUtils.getTitle());

        String validateActualMessage = BasePage.myAccount.validateSignIn();
        Assertions.assertEquals(BasePage.prop.getProperty("signInSuccessMsg"), validateActualMessage);

        BasePage.homePage.clickSignOutLink();

        Assertions.assertEquals(BasePage.prop.getProperty("signInExpectedTitle"), BasePage.driverUtils.getTitle());

    }


    @When("user enters email {string}")
    public void user_enters_email(String eMail)
    {
        BasePage.signInPage.enterEMail(eMail);
    }


    @When("user clicks on create an account button")
    public void user_clicks_on_create_an_account_button()
    {
        BasePage.signInPage.clickCreateAnAccount();
    }

    @Then("user should see the create account error message")
    public void user_should_see_the_create_account_error_message()
    {

        wait = new WebDriverWait(DriverFactory.driver, 20);
        wait.until(ExpectedConditions.visibilityOf(BasePage.signInPage.createErrorMsg));

        if(BasePage.signInPage.getErrorMessage().contains("Invalid"))
        {
            Assertions.assertEquals(BasePage.prop.getProperty("invalidEMailError"),BasePage.signInPage.getErrorMessage());
        }
        else
        {
            Assertions.assertEquals(BasePage.prop.getProperty("accountAlreadyExists"),BasePage.signInPage.getErrorMessage());
        }

        System.out.println(BasePage.signInPage.getErrorMessage());

    }

    @Then("user should be taken to Create An Account page {string}")
    public void user_should_be_taken_to_create_an_account_page(String validationExpectedMsg)
    {
        wait = new WebDriverWait(DriverFactory.driver, 20);
        wait.until(ExpectedConditions.visibilityOf(BasePage.createAccount.pageHeading));

        Assertions.assertEquals(validationExpectedMsg, BasePage.createAccount.valMessage());
    }

    @When("user clicks on register")
    public void user_clicks_on_register()
    {
        wait = new WebDriverWait(DriverFactory.driver, 20);
        wait.until(ExpectedConditions.visibilityOf(BasePage.createAccount.regsiterButton));

        BasePage.createAccount.clickRegister();
    }

    @Then("user should see the create account validation error message")
    public void user_should_see_the_create_account_validation_error_message()
    {
        BasePage.createAccount.getError();
    }

    @When("user enters valid data on the page")
    public void user_enters_valid_data_on_the_page(io.cucumber.datatable.DataTable dataTable)
    {
        wait = new WebDriverWait(DriverFactory.driver, 20);
        wait.until(ExpectedConditions.visibilityOf(BasePage.createAccount.regsiterButton));

        BasePage.createAccount.selectGender(dataTable.cell(0,0));
        BasePage.createAccount.enterFirstName(dataTable.cell(1,1));
        BasePage.createAccount.enterLastName(dataTable.cell(2,1));
        BasePage.createAccount.enterEMail(dataTable.cell(3,1));
        BasePage.createAccount.enterPassword(dataTable.cell(4,1));
        BasePage.createAccount.selectDay(dataTable.cell(5,1));
        BasePage.createAccount.selectMonth(dataTable.cell(6,1));
        BasePage.createAccount.selectYear(dataTable.cell(7,1));
        BasePage.createAccount.enterAddressFName(dataTable.cell(8,1));
        BasePage.createAccount.enterAddressLName(dataTable.cell(9,1));
        BasePage.createAccount.enterAddress1(dataTable.cell(10,1));
        BasePage.createAccount.enterCity(dataTable.cell(11,1));
        BasePage.createAccount.selectState(dataTable.cell(12,1));
        BasePage.createAccount.enterZipCode(dataTable.cell(13,1));
        BasePage.createAccount.selectCountry(dataTable.cell(14,1));
        BasePage.createAccount.enterMobile(dataTable.cell(15,1));
        BasePage.createAccount.enterAlias(dataTable.cell(16,1));

    }

}
