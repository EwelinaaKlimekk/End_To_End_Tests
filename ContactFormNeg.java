package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import page.objects.*;
import utils.ResultTest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static utils.SheetsUpdate.getUpdateCell;

public class ContactFormNeg extends TestBase{

    String testId = "PLUS_CONTACT_NEG";


    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "SearchProvider",dataProviderClass = DataproviderClass.class)
    @Description("The goal of this test to try to send the completed form with all consent with invalid phone number field and check if warning message is displayed")
    public void asUserCompletesContactFormWithInvalidPhoneNumberField(String phoneNumber, String email, String retentionPhoneNumber, String invalidPhoneNumber, String invalidEmail) throws InterruptedException{
        Rodo rodo = new Rodo();
        rodo.clickOnAcceptRodoButton();

        Upper upper = new Upper();
        upper.clickOnContactButton();

        ContactFormPage contactFormPage = new ContactFormPage();
        contactFormPage.enteringPhoneNumberInField(invalidPhoneNumber);
        contactFormPage.enteringEmailInField(email);
        contactFormPage.selectOptionDropDown();
        contactFormPage.clickRetentionSelect();
        contactFormPage.enteringRetentionPhoneNumberInField(retentionPhoneNumber);
        contactFormPage.expandShowingAllConsents();
        contactFormPage.clickConsentToTheProcessingOfPersonalDataThroughCheckBox();
        contactFormPage.clickConsentToReceiveCommercialInformationThroughCheckBox();
        contactFormPage.clickConsentToDirectMarketingThroughCheckBox();
        contactFormPage.checkedAllConsentsCheckBox();
        contactFormPage.informationClauseForDownload();
        contactFormPage.clickFormButton();
        contactFormPage.validationMessageToEmptyPhoneNumberField();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "SearchProvider",dataProviderClass = DataproviderClass.class)
    @Description("The goal of this test to try to send the completed form with all consent with invalid email field and check if warning message is displayed")
    public void asUserCompletesContactFormWithInvalidEmailField(String phoneNumber, String email, String retentionPhoneNumber, String invalidPhoneNumber, String invalidEmail) throws InterruptedException{
        Rodo rodo = new Rodo();
        rodo.clickOnAcceptRodoButton();

        Upper upper = new Upper();
        upper.clickOnContactButton();

        ContactFormPage contactFormPage = new ContactFormPage();
        contactFormPage.enteringPhoneNumberInField(phoneNumber);
        contactFormPage.enteringEmailInField(invalidEmail);
        contactFormPage.selectOptionDropDown();
        contactFormPage.clickRetentionSelect();
        contactFormPage.enteringRetentionPhoneNumberInField(retentionPhoneNumber);
        contactFormPage.expandShowingAllConsents();
        contactFormPage.clickConsentToTheProcessingOfPersonalDataThroughCheckBox();
        contactFormPage.clickConsentToReceiveCommercialInformationThroughCheckBox();
        contactFormPage.clickConsentToDirectMarketingThroughCheckBox();
        contactFormPage.checkedAllConsentsCheckBox();
        contactFormPage.clickFormButton();
        contactFormPage.validationMessageToInvalidEmailField();
    }

    @AfterClass
    public void getTestId(ITestContext result) throws IOException, GeneralSecurityException {

        String rangeResult = getUpdateCell(testId);
        IResultMap mapTestFailed = result.getFailedTests();
        IResultMap mapTestPassed = result.getPassedTests();

        List<ITestResult> results = new ArrayList<>();
        results.addAll(mapTestFailed.getAllResults());
        results.addAll(mapTestPassed.getAllResults());

        ResultTest.resultTests(results, rangeResult);
    }
}
