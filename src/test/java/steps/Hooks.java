package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;

public class Hooks
{
    @Before
    public void setUp()
    {
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario)
    {
        //Adding screenshot of the page to report when the test fails due to an error
        if(scenario.isFailed())
        {
            final byte[] screenShot = ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "errorScreen");
        }

        //DriverFactory.closeDriver();
    }
}
