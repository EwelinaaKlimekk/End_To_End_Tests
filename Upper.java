package page.objects;

import driver.manage.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Upper {

    @FindBy(css = "body > footer > section.upper")
    WebElement upper;

    @FindBy(css = "div:nth-of-type(3) > a > span:nth-of-type(2)")
    WebElement leaveNumberWeWillCallYouBack;

//    @FindBy(className = "kontakt-ind")
    @FindBy(className = "#row-lower-footer-banner .kontakt-ind")
    WebElement contactButton;

    public Upper(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 70);

    Actions action = new Actions(DriverManager.getWebDriver());

    @Step("Click on Leave number We will call you back Link")
    public void clickOnLeaveNumberWeWillCallYouBack() {
//        WebElement leaveNumberWeWillCallYouBack = driver.findElement(By.cssSelector("body > footer > section.upper > div > div:nth-child(3) > a"));
        action.moveToElement(upper).perform();
        wait.until(ExpectedConditions.visibilityOf(upper));

        action.moveToElement(leaveNumberWeWillCallYouBack).click().perform();
//        leaveNumberWeWillCallYouBack.click();

//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
////        WebElement leaveNumberWeWillCallYouBack = driver.findElement(By.cssSelector("body > footer > section.upper > div > div:nth-child(3) > a"));
//        javascriptExecutor.executeScript("arguments[0].click();", leaveNumberWeWillCallYouBack);
    }

    @Step("Click on Contact Button")
    public void clickOnContactButton() {
        Actions action = new Actions (DriverManager.getWebDriver());
        action.moveToElement(contactButton);
        wait.until(ExpectedConditions.visibilityOf(contactButton));
        contactButton.click();
    }
}
