package techproed.tests.day22_DataProvider_XmlFile;

import org.bouncycastle.math.ec.ECCurve;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] araclar() {
        return new Object[][]{{"volvo"},{"mercedes"},{"audi"},{"audi"},{"ford"}};
    }

    @Test(dataProvider = "araclar")
    public void test01(String data) {

        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googgleUrl"));
        
        //DataProvider ile istediğimiz arac isimlerini aratalım
        GooglePage googlePage = new GooglePage();
        googlePage.cookiesKabulEt.click();

        googlePage.aramaKutusu.sendKeys(data, Keys.ENTER);

        Driver.closeDriver();
        
    }
}
