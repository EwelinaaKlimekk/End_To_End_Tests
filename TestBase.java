package tests;

import driver.manage.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.ScreenShotMaker;

public class TestBase {
//    Setting up browser to: {browserType},
    @Step("Setting size window and navigate to Home Page: https://www.plus.pl")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(
//            @Optional BrowserType browserType,
//            String pageUrl
    ){
        DriverManager.getWebDriver();
        DriverManager.getWebDriver().manage().window().maximize();
//        DriverManager.getWebDriver().manage().window().setSize(new Dimension(1360,768));
        DriverManager.getWebDriver().navigate().to("https://www.plus.pl");
        WebDriverWait wait = new WebDriverWait( DriverManager.getWebDriver(), 5);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {
        ScreenShotMaker.makeScreenShot();
        DriverManager.disposeDriver();
    }
}
