package page.objects;

import driver.manage.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import static org.testng.Assert.*;

public class BuyOverPhone {

//    private Logger logger = (Logger) LogManager.getLogger(BuyOverPhone.class);
//    @FindBy(css = "#glcf-footer-form > div.my-fields > div > div:nth-child(1)")
    @FindBy(css = "input#telkontakt-footer")
    WebElement phoneNumberField;

    @FindBy(css = "div#checkbox-ret")
    WebElement retentionCheckBox;

    @FindBy(css = "input#telglowny-footer")
    WebElement retentionPhoneNumberField;

    @FindBy(css = "#glcf-footer-form > div.statements-section > div.statements-ctrl > a.slide-up")
    WebElement expandShowingAllConsentsButton;

    @FindBy(css = "#glcf-footer-form > div.statements-section > div.statements-container > div > div > div:nth-child(1)")
    WebElement consentToTheProcessingOfPersonalDataThroughCheckBox;

    @FindBy(css = "#glcf-footer-form > div.statements-section > div.statements-container > div > div > div:nth-child(2)")
    WebElement consentToReceiveCommercialInformationThroughCheckBox;

    @FindBy(css = "#glcf-footer-form > div.statements-section > div.statements-container > div > div > div:nth-child(3)")
    WebElement consentToDirectMarketingThroughCheckBox;

    @FindBy(css = "#glcf-footer-form > div.statements-section > div.statements-ctrl > a.select-all-statements")
    WebElement allConsentsCheckBox;

    @FindBy(css = "#glcf-footer-form > div.statements-section > a.klauzula")
    WebElement informationClauseForDownloadLink;

    @FindBy(css = "a#submit-footer-form")
    WebElement formButton;

    @FindBy(css = "div:nth-of-type(1) > .otp-error-label")
    WebElement emptyPhoneFieldStatement;

    @FindBy(css = "div:nth-of-type(3) > .otp-error-label")
    WebElement emptyRetentionPhoneNumberFieldStatement;

    @FindBy(css = ".agreements-wrapper .error")
    WebElement uncheckAllConsentsCheckBoxStatement;

    @FindBy(css = "div:nth-of-type(1) > .otp-error-label")
    WebElement uncheckConsentToTheProcessingOfPersonalDataThroughCheckBoxStatement;

    @FindBy(css = "div:nth-of-type(2) > .otp-error-label")
    WebElement uncheckConsentToReceiveCommercialInformationThroughCheckBoxStatement;

    @FindBy(css = "div:nth-of-type(3) > .otp-error-label")
    WebElement uncheckConsentToDirectMarketingThroughCheckBoxStatement;

    @FindBy(css = "#footer-agreements > div:nth-child(1) > label > div")
    WebElement uncheckCheckBoxStatement;

    @FindBy(css= "div:nth-of-type(1) > .otp-error-label")
    WebElement validationMessagePhoneNumberFieldStatement;

    public BuyOverPhone(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 70);

    Actions action = new Actions(DriverManager.getWebDriver());

//    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getWebDriver();

    @Step("Type into Phone number Field {phoneNumber}")
    public void typeInPhoneNumberField(String phoneNumber){
        action.moveToElement(phoneNumberField).build();
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        phoneNumberField.sendKeys(phoneNumber);
        String phoneNumberFielddValue = phoneNumberField.getAttribute("value");
        assertEquals(phoneNumberFielddValue, phoneNumber);
    }

    @Step("Click I want to extend the contract in Plus Checkbox")
    public void clickRetentionCheckBox(){
        action.moveToElement(retentionCheckBox);
        wait.until(ExpectedConditions.elementToBeClickable(retentionCheckBox));
        retentionCheckBox.click();
    }

    @Step("Type into Phone to extend the contract Field {retentionPhoneNumber}")
    public void enteringRetentionPhoneNumberField(String retentionPhoneNumber){
        wait.until(ExpectedConditions.visibilityOf(retentionCheckBox));
        retentionPhoneNumberField.sendKeys(retentionPhoneNumber);
//        wait.until(ExpectedConditions.textToBePresentInElement(retentionCheckBox, "159159159"));
        String retentionPhoneNumberFieldValue = retentionPhoneNumberField.getAttribute("value");
        assertEquals(retentionPhoneNumber, retentionPhoneNumberFieldValue);
    }

    @Step("Expand all consents")
    public void clickExpandShowingAllConsentsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(expandShowingAllConsentsButton));
        expandShowingAllConsentsButton.click();
    }

    @Step("Click the consent to processing personal data Checkbox")
    public void clickConsentToTheProcessingOfPersonalDataThroughCheckBox(){
        consentToTheProcessingOfPersonalDataThroughCheckBox.click();
        consentToTheProcessingOfPersonalDataThroughCheckBox.isSelected();
    }

    @Step("Click the consent to receive commercial information Checkbox")
    public void clickConsentToReceiveCommercialInformationThroughCheckBox(){
        consentToReceiveCommercialInformationThroughCheckBox.click();
        consentToReceiveCommercialInformationThroughCheckBox.isSelected();
    }

    @Step("Click the consent to direct marketing Checkbox")
    public void clickConsentToDirectMarketingThroughCheckBox(){
        consentToDirectMarketingThroughCheckBox.click();
        consentToDirectMarketingThroughCheckBox.isSelected();
    }

    @Step("Click all consents Checkbox")
    public void checkedAllConsentsCheckBox(){
        allConsentsCheckBox.isSelected();
    }

    @Step("Getting form button is displayed")
    public void sendFormButton(){
//        WebElement sendFormButtonIsClickable =
        wait.until(ExpectedConditions.elementToBeClickable(formButton));
        assertTrue(formButton.isDisplayed(), "Przycisk Wyślij nie jest widoczny");
    }

    @Step("Check information clause for download Link")
    public void informationClauseForDownload(){
        assertTrue(informationClauseForDownloadLink.isDisplayed(),"Link Klauzula informacyjna do pobrania nie jest widoczny");
        String informationClauseForDownloadValue = informationClauseForDownloadLink.getAttribute("href");
        assertEquals(informationClauseForDownloadValue, "https://www.plus.pl/documents/16/46a07e29-f922-4aff-942c-049720a15ac5");
    }

    @Step("current URL")
    public void urlDocument() {
        String currentURL = DriverManager.getWebDriver().getCurrentUrl();
        System.out.println(currentURL);
        assertTrue(Boolean.parseBoolean(currentURL), "https://www.plus.pl/documents/16/46a07e29-f922-4aff-942c-049720a15ac5");

        WebElement linkName = DriverManager.getWebDriver().findElement(By.linkText("Name of Link "));

        if(linkName.isDisplayed())
        {
            System.out.println("Yes link is there");
        }
        else
        {
            System.out.println("No link is there");
        }
    }

    @Step("Click Form Button")
    public  void clickFormButton(){
        action.moveToElement(formButton).perform();
//        wait.until(ExpectedConditions.invisibilityOfAllElements(formButton));
        formButton.click();
    }

    @Step("Getting is warning message from empty Phone number Field")
    public void validationMessageToEmptyPhoneField(){
//        wait.until(ExpectedConditions.visibilityOf(emptyPhoneFieldStatement));
        String emptyPhoneFieldText = emptyPhoneFieldStatement.getText();
        assertEquals(emptyPhoneFieldText, "Poprawny format numeru to XXX XXX XXX lub XXXXXXXXX");
    }

    @Step("Getting is warning message from all consents Checkbox")
    public void validationMessageToUncheckAllConsentsChechBox(){
//        wait.until(ExpectedConditions.visibilityOf(uncheckRodoChechBox));
        action.moveToElement(uncheckAllConsentsCheckBoxStatement).perform();
        String uncheckAllConsentsChechBoxStatementText = uncheckAllConsentsCheckBoxStatement.getText();
        assertEquals(uncheckAllConsentsChechBoxStatementText, "Informujemy, że wyrażenie zgód jest dobrowolne, ale bez wyrażenia zgód nie będziemy mogli przyjąć zgłoszenia.");
        assertFalse(uncheckAllConsentsCheckBoxStatement.isSelected(), "Główny CheckBox jest zaznaczony");
    }

    @Step("Getting is warning message for invalid from Phone number Field")
    public void validationMessageToInvalidPhoneNumberField(){
        String invalidPhoneNumberFieldText = validationMessagePhoneNumberFieldStatement.getText();
        assertEquals(invalidPhoneNumberFieldText, "Poprawny format numeru to XXX XXX XXX lub XXXXXXXXX");
    }

    @Step("Getting is warning message from Phone to extend the contract Field")
    public void validationMessageToEmptyRetentionPhoneNumberField() {
        String emptyRetentionPhoneNumberFieldStatementText = emptyRetentionPhoneNumberFieldStatement.getText();
        assertEquals(emptyRetentionPhoneNumberFieldStatementText, "Podaj numer telefonu w formacie xxx xxx xxx lub xx xxx xx xx");
    }

    @Step("Getting is warning message from Consent to the processing of personal data Checkbox")
    public void validationMessageToUncheckConsentToTheProcessingOfPersonalDataThroughCheckBox() {
        String uncheckConsentToTheProcessingOfPersonalDataThroughCheckBoxText = uncheckConsentToTheProcessingOfPersonalDataThroughCheckBoxStatement.getText();
        assertEquals(uncheckConsentToTheProcessingOfPersonalDataThroughCheckBoxText, "Informujemy, że wyrażenie zgód jest dobrowolne, ale bez wyrażenia zgód nie będziemy mogli przyjąć zgłoszenia.");
        assertFalse(uncheckConsentToTheProcessingOfPersonalDataThroughCheckBoxStatement.isSelected(), "Pierwszy CheckBox jest zaznaczony");
    }

    @Step("Getting is warning message from Consent to receive commercial information Checkbox")
    public void validationMessageToUncheckConsentToReceiveCommercialInformationThroughCheckBox() {
        String uncheckConsentToReceiveCommercialInformationThroughCheckBoxText = uncheckConsentToReceiveCommercialInformationThroughCheckBoxStatement.getText();
        assertEquals(uncheckConsentToReceiveCommercialInformationThroughCheckBoxText, "Informujemy, że wyrażenie zgód jest dobrowolne, ale bez wyrażenia zgód nie będziemy mogli przyjąć zgłoszenia.");
        assertFalse(uncheckConsentToReceiveCommercialInformationThroughCheckBoxStatement.isSelected(), "Drugi CheckBox jest zaznaczony");
    }

    @Step("Getting is warning message from Consent to direct marketing Checkbox")
    public void validationMessageToUncheckConsentToDirectMarketingThroughCheckBox() {
        String uncheckConsentToDirectMarketingThroughCheckBoxText = uncheckConsentToDirectMarketingThroughCheckBoxStatement.getText();
        assertEquals(uncheckConsentToDirectMarketingThroughCheckBoxText, "Informujemy, że wyrażenie zgód jest dobrowolne, ale bez wyrażenia zgód nie będziemy mogli przyjąć zgłoszenia.");
        assertFalse(uncheckConsentToDirectMarketingThroughCheckBoxStatement.isSelected(), "Trzeci CheckBox jest zaznaczony");
    }
}