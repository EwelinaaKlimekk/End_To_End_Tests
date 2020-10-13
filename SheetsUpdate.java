package utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Klasa odpowiedzialna za update rezultatu testu w pliku google sheets
 */
public class SheetsUpdate {
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "GoogleSheets";
    private static String SPREADSHEET_ID = "18e2VSVB058XOaNpMY4RxrrT2CA_IKLhMU95LT-vMyT8";

    /**
     * Metoda zwracająca credientiala
     *
     * @return credential
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private static Credential autorize() throws IOException, GeneralSecurityException {
        InputStream in = SheetsUpdate.class.getResourceAsStream("/credentials_plus.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );

        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver())
                .authorize("user");

        return credential;

    }

    /**
     * Metoda, która dzięki credentialowi zwraca odpowiedni obiekt Sheet
     *
     * @return
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = autorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * Metoda, która odpowiada za update daty w dokumencie google sheets
     *
     * @param range zakres
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public static void updateDate(String range) throws IOException, GeneralSecurityException {

        sheetsService = getSheetsService();

        ValueRange appendBody = new ValueRange();

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("       dd-MM-yyyy");
        String formattedString = now.format(formatter);

        appendBody.setValues(Arrays.asList(Arrays.asList(formattedString)));

        UpdateValuesResponse appendValuesResponse = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, range, appendBody)
                .setValueInputOption("RAW")
                .execute();

    }

    /**
     * Metoda, która odpowiada za update kolumny z wynikiem testu - Fail/Pass
     *
     * @param isDisplayed
     * @param range
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public static void updateSheet(boolean isDisplayed, String range) throws IOException, GeneralSecurityException {


        sheetsService = getSheetsService();

        ValueRange appendBody = new ValueRange();

        if (isDisplayed == false) {
            appendBody.setValues(Arrays.asList(
                    Arrays.asList("Fail")
            ));

            UpdateValuesResponse appendValuesResponse = sheetsService.spreadsheets().values()
                    .update(SPREADSHEET_ID, range, appendBody)
                    .setValueInputOption("RAW")
                    .execute();
        } else if (isDisplayed == true) {
            appendBody.setValues(Arrays.asList(
                    Arrays.asList("Pass")
            ));

            UpdateValuesResponse appendValuesResponse = sheetsService.spreadsheets().values()
                    .update(SPREADSHEET_ID, range, appendBody)
                    .setValueInputOption("RAW")
                    .execute();
        }
    }

    public static String getUpdateCell(String testId) throws IOException, GeneralSecurityException {

        sheetsService = getSheetsService();

        String range = "Testy Automatyczne!B3:H";
//        String range = "Daily!A2:D";

        String valueRenderOption = "UNFORMATTED_VALUE";

        String dateTimeRenderOption = "SERIAL_NUMBER";

        Sheets.Spreadsheets.Values.Get request =
                sheetsService.spreadsheets().values().get(SPREADSHEET_ID, range);
        request.setValueRenderOption(valueRenderOption);
        request.setDateTimeRenderOption(dateTimeRenderOption);

        ValueRange response = request.execute();

        List<List<Object>> values = response.getValues();

        int rowNumber = 3;

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i).get(0).equals(testId)) {
                rowNumber += i;
                System.out.println("Founded testId: " + values.get(i).get(0));
            }

        }
        System.out.println(rowNumber);

        String rowNumberString = Integer.toString(rowNumber);

        return rowNumberString;
    }

}

