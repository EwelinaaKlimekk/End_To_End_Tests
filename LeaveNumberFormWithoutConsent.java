package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import page.objects.FormLeaveTheNumberPage;
import page.objects.Rodo;
import page.objects.Upper;
import utils.ResultTest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static utils.SheetsUpdate.getUpdateCell;

public class LeaveNumberFormWithoutConsent extends TestBase{

    String testId = "PLUS_LEAVE_NUMBER_W/O";

    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "SearchProvider",dataProviderClass = DataproviderClass.class)
    @Description("The goal of this test to try to send the empty form with all consents and check if warning messages is displayed")
    public void asUserCompletesFormLeaveNumber_WeWillCallYouBackWithoutConsent(String phoneNumber, String email, String retentionPhoneNumber, String invalidPhoneNumber, String invalidEmail) throws InterruptedException{
        Rodo rodo = new Rodo();
        rodo.clickOnAcceptRodoButton();
        Upper upper = new Upper();
        upper.clickOnLeaveNumberWeWillCallYouBack();

        FormLeaveTheNumberPage formLeaveTheNumberPage = new FormLeaveTheNumberPage();
        formLeaveTheNumberPage.typeInPhoneNumberField(phoneNumber);
        formLeaveTheNumberPage.typeInEmailField(email);
        formLeaveTheNumberPage.expandTheDropDownListWithLabelSelectConversationTopic();
        formLeaveTheNumberPage.clickDataValueInternetOnPlusNetwork();
        formLeaveTheNumberPage.clickExpandShowingAllConsentsButton();
        formLeaveTheNumberPage.clickFormButton();
        formLeaveTheNumberPage.validationMessageToUncheckConsentToTheProcessingOfPersonalDataThroughCheckBox();
        formLeaveTheNumberPage.validationMessageToUncheckConsentToReceiveCommercialInformationThroughCheckBox();
        formLeaveTheNumberPage.validationMessageToUncheckConsentToDirectMarketingThroughCheckBox();
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
