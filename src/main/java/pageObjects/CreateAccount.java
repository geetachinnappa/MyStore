package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DriverFactory;

public class CreateAccount
{
    @FindBy (css = "h3.page-subheading")
    public WebElement pageHeading;

    @FindBy (id = "id_gender1")
    public WebElement genderMale;

    @FindBy (id = "id_gender2")
    public WebElement genderFemale;

    @FindBy (id = "customer_firstname")
    public WebElement customerFName;

    @FindBy (id = "customer_lastname")
    public WebElement customerLName;

    @FindBy (id = "email")
    public WebElement eMail;

    @FindBy (id = "passwd")
    public WebElement password;

    @FindBy (id = "days")
    public WebElement day_dob;

    @FindBy (id = "months")
    public WebElement month_dob;

    @FindBy (id = "years")
    public WebElement year_dob;

    @FindBy (id = "firstname")
    public WebElement FName;

    @FindBy (id = "lastname")
    public WebElement LName;

    @FindBy (id = "address1")
    public WebElement address1;

    @FindBy (id = "city")
    public WebElement city;

    @FindBy (id = "id_state")
    public WebElement state;

    @FindBy (id = "postcode")
    public WebElement postcode;

    @FindBy (id = "id_country")
    public WebElement country;

    @FindBy (id = "phone_mobile")
    public WebElement phoneMobile;

    @FindBy (id = "alias")
    public WebElement alias;

    @FindBy (id = "submitAccount")
    public WebElement regsiterButton;

    @FindBy (css = "div.alert-danger")
    public WebElement reqdAlert;


    public CreateAccount()
    {
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public String valMessage()
    {
        return pageHeading.getText();
    }

    public void clickRegister()
    {
        regsiterButton.click();
    }

    public void getError()
    {
        System.out.println(reqdAlert.getText());
    }

    public void selectGender(String gender)
    {
        if(gender == "1")
            genderMale.click();
        else if(gender == "2")
            genderFemale.click();
    }
    
    public void enterFirstName(String fname)
    {
        customerFName.sendKeys(fname);
    }

    public void enterLastName(String lname)
    {
        customerLName.sendKeys(lname);
    }

    public void selectDay(String day)
    {
        Select dayDOB = new Select(day_dob);
        dayDOB.selectByValue(day);
    }

    public void selectMonth(String month)
    {
        Select monDOB = new Select(month_dob);
        monDOB.selectByValue(month);
    }

    public void selectYear(String year)
    {
        Select yearDOB = new Select(year_dob);
        yearDOB.selectByValue(year);
    }

    public void enterEMail(String email)
    {
        eMail.sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        password.sendKeys(pwd);
    }

    public void enterAddressFName(String addressfname)
    {
        FName.sendKeys(addressfname);
    }

    public void enterAddressLName(String addresslname)
    {
        LName.sendKeys(addresslname);
    }

    public void enterAddress1(String addressline1)
    {
        address1.sendKeys(addressline1);
    }

    public void enterCity(String addresscity)
    {
        city.sendKeys(addresscity);
    }

    public void selectState(String addState)
    {
        Select addressState = new Select(state);
        addressState.selectByValue(addState);
    }

    public void enterZipCode(String zipcode)
    {
        postcode.sendKeys(zipcode);
    }

    public void selectCountry(String addCountry)
    {
        Select addressCountry = new Select(country);
        addressCountry.selectByValue(addCountry);
    }

    public void enterMobile(String mobile)
    {
        phoneMobile.sendKeys(mobile);
    }

    public void enterAlias(String addressalias)
    {
        alias.sendKeys(addressalias);
    }

}
