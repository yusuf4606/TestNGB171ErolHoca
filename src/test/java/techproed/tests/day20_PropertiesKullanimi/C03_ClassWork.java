package techproed.tests.day20_PropertiesKullanimi;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_ClassWork {
    @Test

    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        centerPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        centerPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        centerPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(centerPage.verify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et

        centerPage.logOut.click();
        ReusableMethods.bekle(2);

        softAssert.assertEquals(Driver.getDriver().getTitle(),"Login");

        //sayfayı kapatınız

        Driver.closeDriver();
    }
}
