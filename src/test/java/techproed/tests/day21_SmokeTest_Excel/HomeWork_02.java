package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class HomeWork_02 {

     /*
    Name:
US101122_Negative_Login
Description:
Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
Acceptance Criteria:
Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
Error Message: email must be a valid email
Dogru email uzantisi girildiğinde hata mesajı alınmamalı

    */

    @DataProvider
    public static Object[][] yanlisEmailler() {
        return new Object[][]{{"sam.walkerbluerentalcars.com", "c!fas_art"},
                {"sam.walker@bluerentalcarscom", "c!fas_art"},
                {"sam.walker@bluerentalcars", "c!fas_art"}};
    }

    @Test(dataProvider = "yanlisEmailler")
    public void test01(String email, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        // logine tikla
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        blueRentalPage.userEmail.sendKeys(email, Keys.TAB, password, Keys.ENTER);

        // hata mesajinin ciktigini dogrula
        ReusableMethods.bekle(1);
        Assert.assertTrue(blueRentalPage.emailMustBeAValidEmail.isDisplayed());
    }
    @DataProvider
    public static Object[][] dogruEmailler() {
        return new Object[][]{{"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}};
    }

    @Test(dataProvider = "dogruEmailler")
    public void positiveTest(String email, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        // logine tikla
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        blueRentalPage.userEmail.sendKeys(email, Keys.TAB, password, Keys.ENTER);
        ReusableMethods.bekle(3);

        // giris yapildigini dogrula
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(blueRentalPage.profilButton.isDisplayed());
        blueRentalPage.profilButton.click();
        ReusableMethods.bekle(1);
        blueRentalPage.logout.click();
        blueRentalPage.logOutConfirm.click();
        softAssert.assertAll();
        Driver.closeDriver();
    }
}


