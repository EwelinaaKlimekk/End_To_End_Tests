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

public class OverPhoneFormEmpty extends TestBase{

    String testId = "PLUS_OVER_PHONE_EMPTY";

    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "SearchProvider",dataProviderClass = DataproviderClass.class)
    @Description("The goal of this test to try to send the completed form with all consent without a phone field and check if warning message is displayed")
    public void asUserCompletesFormBuyOverPhoneWithEmptyPhoneNumberField(String phoneNumber, String email, String retentionPhoneNumber, String invalidPhoneNumber, String invalidEmail) throws InterruptedException{
        Rodo rodo = new Rodo();
        rodo.clickOnAcceptRodoButton();

        BuyOverPhone buyOverPhone = new BuyOverPhone();
        buyOverPhone.clickRetentionCheckBox();
        buyOverPhone.enteringRetentionPhoneNumberField(retentionPhoneNumber);
        buyOverPhone.clickExpandShowingAllConsentsButton();
        buyOverPhone.clickConsentToTheProcessingOfPersonalDataThroughCheckBox();
        buyOverPhone.clickConsentToReceiveCommercialInformationThroughCheckBox();
        buyOverPhone.clickConsentToDirectMarketingThroughCheckBox();
        buyOverPhone.checkedAllConsentsCheckBox();
        buyOverPhone.clickFormButton();
        buyOverPhone.validationMessageToEmptyPhoneField();
    }

//    @Severity(SeverityLevel.CRITICAL)
//    @Test
//    @Description("The goal of this test to try to send the empty form without consents and check if warning messages is displayed")
//    public  void emptyFormBuyOverPhone(){
//        Rodo rodo = new Rodo();
//        rodo.clickOnAcceptRodoButton();
//
//        BuyOverPhone buyOverPhone = new BuyOverPhone();
//        buyOverPhone.clickFormButton();
//        buyOverPhone.validationMessageToEmptyPhoneField();
////        buyOverPhone.validationMessageToUncheckAllConsentsChechBox();
//        buyOverPhone.validationMessageToUncheckConsentToTheProcessingOfPersonalDataThroughCheckBox();
//        buyOverPhone.validationMessageToUncheckConsentToReceiveCommercialInformationThroughCheckBox();
//        buyOverPhone.validationMessageToUncheckConsentToDirectMarketingThroughCheckBox();
//    }


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
