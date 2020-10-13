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

import static org.testng.Assert.*;

public class FormLeaveTheNumberPage {

    @FindBy(css = "input#nr_kontakt")
    WebElement enteringPhoneNumberInField;

    @FindBy(css = "input#email")
    WebElement enteringEmailInField;

    @FindBy(css = "div#select-option > a")
    WebElement selectOptionDropDown;

    @FindBy(css = "#select-option > div.choice-cont > div:nth-child(4)")
    WebElement internetOnPlusNetwork;

    @FindBy(css = ".slide-up")
    WebElement expandShowingAllConsentsButton;

    @FindBy(css = "div.dev-statements-checkbox:nth-child(1) > label:nth-child(1)")
    WebElement consentToTheProcessingOfPersonalDataThroughCheckBox;

    @FindBy(css = "div.dev-statements-checkbox:nth-child(2) > label:nth-child(1)")
    WebElement consentToReceiveCommercialInformationThroughCheckBox;

    @FindBy(css = "div.dev-statements-checkbox:nth-child(3) > label:nth-child(1)")
    WebElement consentToDirectMarketingThroughCheckBox;

    @FindBy(css = "#super-contact-form-main > div > div.statements-section > div.statements-ctrl > a.select-all-statements.active-agree")
    WebElement allConsentsCheckBox;

    @FindBy(css = "button#show-all-statement")
    WebElement fullInformationOnProcessingOfPersonalDataButton;

    @FindBy(css = "#klauzula-info > div > div.klauzula-statements > a")
    WebElement informationClauseForDownloadLink;

    @FindBy(css = "a#submit-super-cf")
    WebElement sendButton;

    @FindBy(css = ".input-section > div:nth-of-type(1) > .otp-error-label")
    WebElement validationMessagePhoneNumberFieldStatement;

    @FindBy(css = ".input-section > div:nth-of-type(2) > .otp-error-label")
    WebElement validationMessageEmailFieldStatement;

    @FindBy(css = "div#select-option > .otp-error-label")
    WebElement unselectOptionDropDownStatement;

    @FindBy(css = ".states > div:nth-of-type(1) > .otp-error-label")
    WebElement uncheckConsentToTheProcessingOfPersonalDataThroughCheckBoxStatement;

    @FindBy(css = ".states > div:nth-of-type(2) > .otp-error-label")
    WebElement uncheckConsentToReceiveCommercialInformationThroughCheckBoxStatement;

    @FindBy(css = ".states > div:nth-of-type(3) > .otp-error-label")
    WebElement uncheckConsentToDirectMarketingThroughCheckBoxStatement;

    public FormLeaveTheNumberPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 70);

    Actions action = new Actions(DriverManager.getWebDriver());

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getWebDriver();

    @Step("Type into Phone number Field {phoneNumber}")
    public void typeInPhoneNumberField(String phoneNumber){
//        WebElement enteringPhoneNumberInField = driver.findElement(By.name("nr_kontakt"));
        enteringPhoneNumberInField.sendKeys(phoneNumber);
        String nr_kontaktFieldValue = enteringPhoneNumberInField.getAttribute("value");
        assertEquals(nr_kontaktFieldValue, phoneNumber);
    }

    @Step("Type into Email Field {email}")
    public void typeInEmailField(String email){
        enteringEmailInField.sendKeys(email);
        String emailFieldValue = enteringEmailInField.getAttribute("value");
        assertEquals(emailFieldValue, email);
    }

    @Step("Expand Conversation topic Dropdown")
    public void expandTheDropDownListWithLabelSelectConversationTopic(){
        selectOptionDropDown.click();
    }

    @Step("Select Internet on the plus network Dropdown")
    public void clickDataValueInternetOnPlusNetwork(){
        action.moveToElement(internetOnPlusNetwork).click().perform();
        internetOnPlusNetwork.isDisplayed();
    }

    @Step("Click Expand all consents")
    public void clickExpandShowingAllConsentsButton(){
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

//    public void uncheckConsentToTheProcessingOfPersonalDataThroughCheckBox(){
//        consentToTheProcessingOfPersonalDataThroughCheckBox.click();
//        assertFalse(consentToTheProcessingOfPersonalDataThroughCheckBox.isSelected(),"nieodkliknięty CheckBox");
//    }
//
//    public void uncheckConsentToReceiveCommercialInformationThroughCheckBox(){
//        consentToReceiveCommercialInformationThroughCheckBox.click();
//        assertFalse(consentToReceiveCommercialInformationThroughCheckBox.isSelected(),"nieodkliknięty CheckBox");
//    }
//
//    public void uncheckConsentToDirectMarketingThroughCheckBox(){
//        consentToDirectMarketingThroughCheckBox.click();
//        assertFalse(consentToDirectMarketingThroughCheckBox.isSelected(),"nieodkliknięty CheckBox");
//    }

    @Step("Click Expand Showing full information on processing of personal data Button")
    public void expandShowingFullInformationOnProcessingOfPersonalDataButton(){
        fullInformationOnProcessingOfPersonalDataButton.click();
    }

    @Step("Check information clause for download Link")
    public void informationClauseForDownload() {
        action.moveToElement(informationClauseForDownloadLink).perform();
        assertTrue(informationClauseForDownloadLink.isDisplayed(), "Link Klauzula informacyjna do pobrania nie jest widoczny");
        String informationClauseForDownloadValue = informationClauseForDownloadLink.getAttribute("href");
        assertEquals(informationClauseForDownloadValue, "https://www.plus.pl/documents/16/46a07e29-f922-4aff-942c-049720a15ac5");
    }

    @Step("Getting form button is displayed")
    public void sendFormButton() {
        action.moveToElement(sendButton).perform();
//        WebElement sendFormButtonIsClickable =
//        wait.until(ExpectedConditions.elementToBeClickable(formButton));
        assertTrue(sendButton.isDisplayed(), "Przycisk Wyślij nie jest widoczny");
    }

    @Step("Click Form Button")
    public void clickFormButton() {
        action.moveToElement(sendButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(sendButton));
//        javascriptExecutor.executeScript("arguments[0].click();", sendButton);
        sendButton.click();
    }

    @Step("Getting is warning message from empty Phone number Field")
    public void validationMessageToEmptyPhoneNumberField(){
        String emptyPhoneNumberFieldText = validationMessagePhoneNumberFieldStatement.getText();
        assertEquals(emptyPhoneNumberFieldText, "Poprawny format numeru to XXX XXX XXX lub XXXXXXXXX");
    }

    @Step("Getting is warning message from empty Email Field")
    public void validationMessageToEmptyEmailField(){
        String emptyEmailFieldText = validationMessageEmailFieldStatement.getText();
        assertEquals(emptyEmailFieldText, "Pole wymagane");
    }

    @Step("Getting is warning message for invalid from Phone number Field")
    public void validationMessageToInvalidPhoneNumberField(){
        String invalidPhoneNumberFieldText = validationMessagePhoneNumberFieldStatement.getText();
        assertEquals(invalidPhoneNumberFieldText, "Poprawny format numeru to XXX XXX XXX lub XXXXXXXXX");
    }

    @Step("Getting is warning message for invalid from Email Field")
    public void validationMessageToInvalidEmailField(){
        String invalidEmailFieldText = validationMessageEmailFieldStatement.getText();
        assertEquals(invalidEmailFieldText, "Błędny e-mail");
    }

    @Step("Getting is warning message from unselected Expand Conversation topic Dropdown")
    public void validationMessageToUnselectOptionDropDown (){
        String unselectOptionDropDownText = unselectOptionDropDownStatement.getText();
        assertEquals(unselectOptionDropDownText, "Proszę wybrać jedną z opcji");
    }

    @Step("Getting is warning message from Consent to the processing of personal data Checkbox")
    public void validationMessageToUncheckConsentToTheProcessingOfPersonalDataThroughCheckBox() {
        wait.until(ExpectedConditions.visibilityOf(uncheckConsentToTheProcessingOfPersonalDataThroughCheckBoxStatement));
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
