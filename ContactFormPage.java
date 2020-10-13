package page.objects;

import driver.manage.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;

public class ContactFormPage {

    @FindBy(css="#tabs > li.service.active.tab > div > ul > li:nth-child(1) > a")
    WebElement formButton;

    @FindBy(css = "input#nr_kontakt")
    WebElement phoneNumberField;

//    @FindBy(css = "input#email")
    @FindBy(name = "email")
    WebElement emailField;

//    @FindBy(xpath = "//div[@id='select-option']/a[@href='#']")
    @FindBy(css = "div#select-option > a")
    WebElement optionDropDown;

//    @FindBy(css = "#select-option > div.choice-cont > div:nth-child(4)")
    @FindBy(css = "[data-val='3']")
    WebElement retentionSelect4;

    @FindBy(css = "#select-option > div.choice-cont.hidden > div.active-choice")
    WebElement activeRetentionSelect4;

    @FindBy(css = "#nr_glowny")
    WebElement retentionPhoneNumberField;

    @FindBy(css = "#super-contact-form-new-contact > div > div.statements-section > div.statements-ctrl > a.slide-up")
    WebElement allConsentsButton;

    @FindBy(css = "[for='zgoda0']")
//    @FindBy(css = "#super-contact-form-new-contact > div > div.statements-section > div.statements-container > div > div > div:nth-child(1) > label")
    WebElement consentToTheProcessingOfPersonalDataThroughCheckBox;

    @FindBy(css = "[for='zgoda1']")
//    @FindBy(css = "#super-contact-form-new-contact > div > div.statements-section > div.statements-container > div > div > div:nth-child(2) > label")
    WebElement consentToReceiveCommercialInformationThroughCheckBox;

    @FindBy(css = "[for='zgoda2']")
//    @FindBy(css = "#super-contact-form-new-contact > div > div.statements-section > div.statements-container > div > div > div:nth-child(3) > label")
    WebElement consentToDirectMarketingThroughCheckBox;

    @FindBy(css = ".statements-ctrl > .select-all-statements")
    WebElement allConsentsCheckBox;

    @FindBy(css = "button#show-all-statement")
    WebElement fullInformationOnProcessingOfPersonalDataButton;

    @FindBy(css = "#klauzula-info > div > div.klauzula-statements > a")
    WebElement informationClauseForDownloadLink;

    @FindBy(css = "a#submit-super-cf")
    WebElement sendButton;

    @FindBy(xpath = "//*[@id=\"submit-super-cf-old\"]")
    WebElement sendxpathButton;

    @FindBy(css = "div:nth-of-type(1) > .otp-error-label")
    WebElement emptyPhoneNumberFieldStatement;

    @FindBy(css = "div:nth-of-type(2) > .otp-error-label")
    WebElement EmailFieldStatement;

    @FindBy(css = "div#select-option > .otp-error-label")
    WebElement unselectedOptionDropDownStatement;

    @FindBy(css = ".states > div:nth-of-type(1) > .otp-error-label")
    WebElement uncheckConsentToTheProcessingOfPersonalDataThroughCheckBoxStatement;

    @FindBy(css = ".states > div:nth-of-type(2) > .otp-error-label")
    WebElement uncheckConsentToReceiveCommercialInformationThroughCheckBoxStatement;

    @FindBy(css = ".states > div:nth-of-type(3) > .otp-error-label")
    WebElement uncheckConsentToDirectMarketingThroughCheckBoxStatement;

    WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 70);

    Actions actions = new Actions(DriverManager.getWebDriver());

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getWebDriver();

    public ContactFormPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Scroll to form")
    public void scrollToForm(){
        formButton.click();
    }

    @Step("Type into Phone number Field {phoneNumber}")
    public void enteringPhoneNumberInField(String phoneNumber){
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        phoneNumberField.sendKeys(phoneNumber);
        String nr_kontaktFieldValue = phoneNumberField.getAttribute("value");
        assertEquals(nr_kontaktFieldValue, phoneNumber);
    }

    @Step("Type into Email Field {email}")
    public void enteringEmailInField(String email){
        actions.moveToElement(emailField);
        emailField.sendKeys(email);
        String emailFieldValue = emailField.getAttribute("value");
        assertEquals(emailFieldValue, email);
    }

    @Step("Expand Conversation topic Dropdown")
    public void selectOptionDropDown(){

//        Select dropDown = new Select(optionDropDown);
//       dropDown.selectByIndex(3);
//      dropDown.selectByValue("3");
//        dropDown.selectByVisibleText("Przedłużam umowę");

//        javascriptExecutor.executeScript("arguments[0].click();", optionDropDown);

//        wait.until(ExpectedConditions.textToBePresentInElement(optionDropDown, "Wybierz temat rozmowy"));
//        actions.moveToElement(optionDropDown).perform();
//        optionDropDown.click();
//        actions.moveToElement(optionDropDown).perform();
//        Boolean waitForChooseTopicOfConversation =
//        wait.until(ExpectedConditions.textToBePresentInElement(optionDropDown, "Wybierz temat rozmowy"));
//        optionDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(retentionSelect4));
        actions.moveToElement(retentionSelect4).click().perform();
        activeRetentionSelect4.isDisplayed();

//        Select dropDown = new Select(optionDropDown);
//        wait.until(ExpectedConditions.textToBePresentInElement(optionDropDown, "Wybierz temat rozmowy"));
//        dropDown.selectByVisibleText("Przedłużam umowę");
//        assertEquals(dropDown.getFirstSelectedOption().getText(),"Przedłużam umowę");
    }

    @Step("Select I extend the contract Dropdown")
    public void clickRetentionSelect(){
//        javascriptExecutor.executeScript("arguments[0].click();", retentionSelect4);
        wait.until(ExpectedConditions.elementToBeClickable(retentionSelect4));
        actions.moveToElement(retentionSelect4).perform();
        retentionSelect4.click();
        activeRetentionSelect4.isDisplayed();
    }

    @Step("Type into Telephone number to which the extension applies Field {retentionPhoneNumber}")
    public void enteringRetentionPhoneNumberInField(String retentionPhoneNumber){
        retentionPhoneNumberField.sendKeys(retentionPhoneNumber);
        String retentionPhoneNumberFieldValue = retentionPhoneNumberField.getAttribute("value");
        assertEquals(retentionPhoneNumberFieldValue, retentionPhoneNumber);
    }

    @Step("Click Expand all consents")
    public void expandShowingAllConsents(){
//        javascriptExecutor.executeScript("arguments[0].click();", allConsentsButton);
        actions.moveToElement(allConsentsButton);
        wait.until(ExpectedConditions.elementToBeClickable(allConsentsButton));
        allConsentsButton.click();
    }

    @Step("Click the consent to processing personal data Checkbox")
    public void clickConsentToTheProcessingOfPersonalDataThroughCheckBox(){
        javascriptExecutor.executeScript("arguments[0].click();", consentToTheProcessingOfPersonalDataThroughCheckBox);
//        wait.until(ExpectedConditions.elementToBeClickable(consentToTheProcessingOfPersonalDataThroughCheckBox));
//        consentToTheProcessingOfPersonalDataThroughCheckBox.click();
        consentToTheProcessingOfPersonalDataThroughCheckBox.isSelected();
    }

    @Step("Click the consent to receive commercial information Checkbox")
    public void clickConsentToReceiveCommercialInformationThroughCheckBox(){
        javascriptExecutor.executeScript("arguments[0].click();", consentToReceiveCommercialInformationThroughCheckBox);
//        actions.moveToElement(consentToReceiveCommercialInformationThroughCheckBox);
//        consentToReceiveCommercialInformationThroughCheckBox.click();
        consentToReceiveCommercialInformationThroughCheckBox.isSelected();
    }

    @Step("Click the consent to direct marketing Checkbox")
    public void clickConsentToDirectMarketingThroughCheckBox(){
        javascriptExecutor.executeScript("arguments[0].click();", consentToDirectMarketingThroughCheckBox);
//        actions.moveToElement(consentToDirectMarketingThroughCheckBox);
//        consentToDirectMarketingThroughCheckBox.click();
        consentToDirectMarketingThroughCheckBox.isSelected();
    }

    @Step("Click all consents Checkbox")
    public void checkedAllConsentsCheckBox(){
        allConsentsCheckBox.isSelected();
    }

//    assertFalse(consentToTheProcessingOfPersonalDataThroughCheckBox.isSelected(),"CheckBox jest zaznaczony");
//    assertFalse(consentToReceiveCommercialInformationThroughCheckBox.isSelected(),"ChceckBox jest zaznaczony");
//    assertFalse(consentToDirectMarketingThroughCheckBox.isSelected(),"ChceckBox jest zaznaczony");

    @Step("Click Expand Showing full information on processing of personal data Button")
    public void expandShowingFullInformationOnProcessingOfPersonalDataButton(){
        javascriptExecutor.executeScript("arguments[0].click();", fullInformationOnProcessingOfPersonalDataButton);
//        fullInformationOnProcessingOfPersonalDataButton.click();
    }

    @Step("Check information clause for download Link")
    public void informationClauseForDownload() {
//        actions.moveToElement(informationClauseForDownloadLink).perform();
        wait.until(ExpectedConditions.elementToBeClickable(fullInformationOnProcessingOfPersonalDataButton));
        javascriptExecutor.executeScript("arguments[0].click();", fullInformationOnProcessingOfPersonalDataButton);
//        wait.until(ExpectedConditions.visibilityOf(fullInformationOnProcessingOfPersonalDataButton));
        javascriptExecutor.executeScript("", informationClauseForDownloadLink);
//        assertTrue(informationClauseForDownloadLink.isDisplayed(), "Link Klauzula informacyjna do pobrania nie jest widoczny");
        String informationClauseForDownloadValue = informationClauseForDownloadLink.getAttribute("href");
        assertEquals(informationClauseForDownloadValue, "https://www.plus.pl/documents/16/46a07e29-f922-4aff-942c-049720a15ac5");
    }

    @Step("Getting form button is displayed")
    public void sendFormButton(){
        javascriptExecutor.executeScript("", sendButton);
//        actions.moveToElement(sendxpathButton).perform();
        assertTrue(sendButton.isDisplayed(), "Przycisk Wyślij nie jest widoczny");
    }

    @Step("Click Form Button")
    public void clickFormButton(){
        javascriptExecutor.executeScript("arguments[0].click();", sendButton);
//        actions.moveToElement(sendButton).perform();
//        sendButton.click();
    }

    @Step("Click Form Button")
    public void clickxpathFormButton(){
        actions.moveToElement(sendxpathButton).perform();
        sendxpathButton.click();
    }

    @Step("Getting is warning message from empty Phone number Field")
    public void validationMessageToEmptyPhoneNumberField(){
        actions.moveToElement(emptyPhoneNumberFieldStatement).perform();
        String emptyPhoneNumberFieldText = emptyPhoneNumberFieldStatement.getText();
        assertEquals(emptyPhoneNumberFieldText, "Poprawny format numeru to XXX XXX XXX lub XXXXXXXXX");
    }

    @Step("Getting is warning message from empty Email Field")
    public void validationMessageToEmptyEmailField(){
        String emptyEmailFieldText = EmailFieldStatement.getText();
        assertEquals(emptyEmailFieldText, "Pole wymagane");
    }

    @Step("Getting is warning message for invalid from Email Field")
    public void validationMessageToInvalidEmailField(){
        String invalidEmailFieldText = EmailFieldStatement.getText();
        assertEquals(invalidEmailFieldText, "Błędny e-mail");
    }

    @Step("Getting is warning message from unselected Expand Conversation topic Dropdown")
    public void validationMessageToUnselectOptionDropDown (){
        String unselectOptionDropDownText = unselectedOptionDropDownStatement.getText();
        assertEquals(unselectOptionDropDownText, "Proszę wybrać jedną z opcji");
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
