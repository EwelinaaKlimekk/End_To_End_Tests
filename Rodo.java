package page.objects;

import driver.manage.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rodo {

    @FindBy(xpath = "//a[@id='rodo-accept-all']")
    WebElement acceptRodoButton;

    public Rodo(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on accept Rodo Button")
    public void clickOnAcceptRodoButton(){
//        WebElement acceptRodoButton = driver.findElement(By.xpath("//a[@id='rodo-accept-all']"));
        acceptRodoButton.click();
    }
}
