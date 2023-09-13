package techproed.tests.day21_SmokeTest_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
import java.io.FileInputStream;
import java.io.IOException;

public class HomeWork_03 {
            /*
        Name:
        US101201_Negative_Login
        Description:
        Geçerli giriş yapmadan rezervasyon yapamamalı
        Acceptance Criteria:
        Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
        Ve giris yapilmadiginda
        Hata mesaji almali : Please first login
        Giris yapildiginda hata mesaji alınmamalı
            */

    @Test
    public void negativeTest() {
        // Bluerental websayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        // arac secilir
        BlueRentalPage rentalPage = new BlueRentalPage();
        ReusableMethods.ddmIndex(rentalPage.carSelectDDM, 7);

        rentalPage.pickUPselectPlace.sendKeys("Eskisehir",    // araci aldigimiz sehiri sectik
                Keys.TAB, "Eskisehir",          // araci biraktigimiz sehri sectik
                Keys.TAB, "15092023",           // alis tarihi
                Keys.TAB, "0800",               // alis saati
                Keys.TAB, "20092023",           // araci birakma tarihi
                Keys.TAB, "0800",               // birakma saati
                Keys.ENTER);                    // continue butonuna bastik
        Assert.assertTrue(rentalPage.pleaseFirstLoginText.isDisplayed());
    }

    @Test
    public void positiveTest() throws IOException {
        // Bluerental websayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        // arac secilir
        BlueRentalPage rentalPage = new BlueRentalPage();

        rentalPage.loginButton.click();
        ReusableMethods.bekle(2);

        // excel dosyamizdan usarname ve password alalim
        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaAdi = "customer_info";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String usarname = workbook.getSheet(sayfaAdi).getRow(1).getCell(0).toString();
        String password = workbook.getSheet(sayfaAdi).getRow(1).getCell(1).toString();
        // usarname ve email gir
        rentalPage.userEmail.sendKeys(usarname,
                Keys.TAB, password,
                Keys.ENTER);
        ReusableMethods.bekle(2);
        // giris yapildigini dogrulayalim --> logOut butonu gorunur mu?
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rentalPage.profilButton.isDisplayed());
        softAssert.assertAll();
    }
}
