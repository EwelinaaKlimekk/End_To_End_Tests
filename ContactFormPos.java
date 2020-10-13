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

public class ContactFormPos extends TestBase{

    String testId = "PLUS_CONTACT_POS";

    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "SearchProvider",dataProviderClass = DataproviderClass.class)
//            (invocationCount = 10)
    @Description("The goal of this test to complete the form, check all consents and check that the send button is clickable")
    public void asUserCompletesContactForm(String phoneNumber, String email, String retentionPhoneNumber, String invalidPhoneNumber, String invalidEmail) throws InterruptedException{
        Rodo rodo = new Rodo();
        rodo.clickOnAcceptRodoButton();

        Upper upper = new Upper();
        upper.clickOnContactButton();

        ContactFormPage contactFormPage = new ContactFormPage();
//        contactFormPage.scrollToForm();
        contactFormPage.enteringPhoneNumberInField(phoneNumber);
        contactFormPage.enteringEmailInField(email);
        contactFormPage.selectOptionDropDown();
        contactFormPage.clickRetentionSelect();
        contactFormPage.enteringRetentionPhoneNumberInField(retentionPhoneNumber);
        contactFormPage.expandShowingAllConsents();
        contactFormPage.clickConsentToTheProcessingOfPersonalDataThroughCheckBox();
        contactFormPage.clickConsentToReceiveCommercialInformationThroughCheckBox();
        contactFormPage.clickConsentToDirectMarketingThroughCheckBox();
//        contactFormPage.informationand data administrator
        contactFormPage.checkedAllConsentsCheckBox();
        contactFormPage.expandShowingFullInformationOnProcessingOfPersonalDataButton();
        contactFormPage.informationClauseForDownload();
        contactFormPage.sendFormButton();
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
