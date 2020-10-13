package tests;

import org.testng.annotations.Test;
import page.objects.Rodo;
import page.objects.Url;

public class UrlTest {
    @Test
    public  void url(){
        Rodo rodo = new Rodo();
        rodo.clickOnAcceptRodoButton();

        Url url = new Url();
        url.url();
    }
}
