package techproed.tests.day19_POM;

import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Driver;

public class C03_PageKullanimi {
    @Test
    public void test01() {

        //amazon sayfasına gidelim
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().navigate().refresh();
        //arama kutusunda iphone aratalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("iphone");


    }
}
