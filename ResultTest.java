
package utils;
import org.testng.ITestResult;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ResultTest {

    public static void resultTests(List<ITestResult> results, String rangeResult) {
        for (ITestResult r : results) {
            r.getStatus();
            if (r.getStatus() == ITestResult.FAILURE) {
                try {
                    SheetsUpdate.updateSheet(false, "Testy Automatyczne!D" + rangeResult);
                    SheetsUpdate.updateDate("Testy Automatyczne!E" + rangeResult);
                    break;
                } catch (GeneralSecurityException | IOException b) {
                    b.printStackTrace();
                }
            } else if (r.getStatus() == ITestResult.SUCCESS) {
                try {
                    SheetsUpdate.updateSheet(true, "Testy Automatyczne!D" + rangeResult);
                    SheetsUpdate.updateDate("Testy Automatyczne!E" + rangeResult);
                    continue;
                } catch (GeneralSecurityException | IOException a) {
                    a.printStackTrace();
                }
            }
        }
    }

//    public static void resultTests(List<ITestResult> results, String rangeResult) {
//        for (ITestResult r : results) {
//            r.getStatus();
//            if (r.getStatus() == ITestResult.FAILURE) {
//                try {
//                    SheetsUpdate.updateSheet(false, "Daily!D" + rangeResult);
//                    SheetsUpdate.updateDate("Daily!F" + rangeResult);
//                    break;
//                } catch (GeneralSecurityException | IOException b) {
//                    b.printStackTrace();
//                }
//            } else if (r.getStatus() == ITestResult.SUCCESS) {
//                try {
//                    SheetsUpdate.updateSheet(true, "Daily!D" + rangeResult);
//                    SheetsUpdate.updateDate("Daily!F" + rangeResult);
//                    continue;
//                } catch (GeneralSecurityException | IOException a) {
//                    a.printStackTrace();
//                }
//            }
//        }
//    }
}
