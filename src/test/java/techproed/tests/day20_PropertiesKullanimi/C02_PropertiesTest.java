package techproed.tests.day20_PropertiesKullanimi;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class C02_PropertiesTest {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage sourcePage = new OpenSourcePage();
        sourcePage.userName.sendKeys(ConfigReader.getProperty("OSourceUserName"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("OSourcePassword"));
        sourcePage.loginButton.click();

        //Login Testinin basarili oldugunu test et
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(sourcePage.verify));

        Assert.assertTrue(sourcePage.verify.isDisplayed());

        //sayfayi kapatınız
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }@Test
    public void test02() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        String url = ConfigReader.getProperty("OpenSourceUrl");
        Driver.getDriver().get(url);

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage sourcePage = new OpenSourcePage();
        String username = ConfigReader.getProperty("OSourceUserName");
        String password = ConfigReader.getProperty("OSourcePassword");
        sourcePage.userName.sendKeys(username, Keys.TAB,password,Keys.ENTER);


        //Login Testinin basarili oldugunu test et
        ReusableMethods.visibleWait(sourcePage.verify,15);

        Assert.assertTrue(sourcePage.verify.isDisplayed());

        //sayfayi kapatınız
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
