package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PositiveSmokeTest {
    @Test(groups = "smoke")
    public void positifTest() {

        //Name: US100201_Admin_Login
        //Description:
        //Admin bilgileriyle giriş
        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //https://www.bluerentalcars.com/
        //Admin email: sam.walker@bluerentalcars.com
        //Admin password: c!fas_art

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        BlueRentalPage rentalPage = new BlueRentalPage();

        rentalPage.loginButton.click();
        rentalPage.userEmail.sendKeys(ConfigReader.getProperty("blueRentalEmail"),
                Keys.TAB,
                ConfigReader.getProperty("blueRentalPassword"),
                Keys.ENTER);

        ReusableMethods.bekle(2);
        Assert.assertTrue(rentalPage.verify.isDisplayed());

    }
}
