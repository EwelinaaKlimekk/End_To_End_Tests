package page.objects;

import driver.manage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    @FindBy(css = "#headerMenu > section.upper.row.is-ind-menu > div:nth-child(3) > a")
    WebElement logInLink;

    public TopMenuPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnLogInLink(){
        logInLink.click();
    }
}
