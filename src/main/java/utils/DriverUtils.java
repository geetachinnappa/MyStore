package utils;

import base.BasePage;

/**
 * Generic utilities page
 */

public class DriverUtils
{
    public void navigateToUrl(String url)
    {
        DriverFactory.driver.navigate().to(url);
    }

    public String getTitle()
    {
        return DriverFactory.driver.getTitle();
    }

    public void pageRefresh()
    {
        DriverFactory.driver.navigate().refresh();
    }

    public void goBackToPreviousPage()
    {
        DriverFactory.driver.navigate().back();
    }

    public boolean checkEmailFormat(String email)
    {
        return email.matches(BasePage.prop.getProperty("emailFormat"));
    }
}
