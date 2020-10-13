package tests;

import org.testng.annotations.DataProvider;

public class DataproviderClass {
    @DataProvider(name="SearchProvider")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "123456789", "ewelina.klimek1@plus.pl", "400300200", "12345678","@gmail.com"},
                { "444555666", "e@0.com", "783033339", "1234567890", "www.plus.pl" },
                { "105105105", "test@gmail.pl", "852852852", "12345O789", "test.gmail.com"},
                { "601602601", "ewelina.klimek@execon.pl", "753753753", "+48 775 49 12","@.pl"}
        };
    }
}