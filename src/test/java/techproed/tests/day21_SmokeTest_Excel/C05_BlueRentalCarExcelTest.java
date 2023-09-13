package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C05_BlueRentalCarExcelTest {
    @Test
    public void excelTest() {
        // BlueRentalCar sayfasina gidelim,
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        // login e tikla
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.loginButton.click();
        ReusableMethods.bekle(2);
        
        // excel deki tum kullanici bilgileri ile login ol, login oldugumuzu dogrulayalim

        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaismi = "customer_info";

        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaismi);

        for (int i = 1; i <=reader.rowCount(); i++) {
            String email = reader.getCellData(i,0);
            String password =reader.getCellData(i,1);
            rentalPage.loginButton.click();
            ReusableMethods.bekle(2);
            rentalPage.userEmail.sendKeys(email, Keys.TAB,password,Keys.ENTER);
            Assert.assertTrue(rentalPage.verifyLogin.isDisplayed());
            ReusableMethods.bekle(2);
            rentalPage.profilButton.click();
            ReusableMethods.bekle(2);
            rentalPage.logout.click();
            ReusableMethods.bekle(2);
            rentalPage.okButton.click();
            
        }
        // sayfayi kapatalim







    }
}
