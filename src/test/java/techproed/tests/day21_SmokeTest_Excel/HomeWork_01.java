package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class HomeWork_01 {
    /*
    Name:
    US100402_Negative_Login
    Description:
    Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
    Acceptance Criteria:
    Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
    Hata Mesaji:
    Bad credentials
    Test Data:
    Customer email: jack@gmail.com
    Customer password: fakepass
    */

    @Test
    public void test01() {
        // sayfaya git

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        // login butonuna bas
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.loginButton.click();
        ReusableMethods.bekle(2);
        rentalPage.userEmail.sendKeys(ConfigReader.getProperty("blueRental2email"), // dogru email girdi
                Keys.TAB,ConfigReader.getProperty("fakePassword"), // fake password girdi
                Keys.ENTER); // login e basti

        // hata mesajini alınmalı  Hata Mesaji: Bad credentials
        System.out.println(rentalPage.badCredentialYazisi.getText());
        Assert.assertTrue(rentalPage.badCredentialYazisi.isDisplayed());






    }
}
