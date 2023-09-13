package techproed.tests.day19_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.Driver;

public class C04_PageKullanimi {
    @Test
    public void test01() throws InterruptedException {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim

        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım

        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.userName.sendKeys("Admin");   //kullanici=Admin
        openSourcePage.password.sendKeys("admin123");  //kullaniciSifre=admin123
        openSourcePage.loginButton.click();   //Login Testinin basarili oldugunu test et

        Thread.sleep(3000);

        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(openSourcePage.verify.isDisplayed());

        //sayfayı kapatınız
        Driver.closeDriver();


    }

}
