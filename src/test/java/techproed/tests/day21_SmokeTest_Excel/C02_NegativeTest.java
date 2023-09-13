package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_NegativeTest {
    /*
    Negatif test senaryolarinda sayfaya giris yapilamamasi ile ilgili senaryolari olusturmamiz gerekir.
     bunun icin önce ornekteki gibi girmemiz gereken emil daki mesela bir @ isareti ya da bir noktalama
     isareti email de olmdadan sifre dogru olsa bile giris yapamamamiz gerekir. ayni sekilde email dogru
      olsa biile sifre yanlis olsa yine giris yapilamamalidir. dolayisiyla negatif testlerde bu senaryolari
       goz onunde builundurup buna gore test case lerimmizi yazmamiz gerekir
     */
    @Test(groups = "smoke")
    public void test01() {

        //Name:
        //US100208_Negative_Login
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found


        // BluerentalCar sayfasina gidelim

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        // Login butonuna tiklayalim
        BlueRentalPage rentalPage = new BlueRentalPage();

        rentalPage.loginButton.click();


        rentalPage.userEmail.sendKeys(ConfigReader.getProperty("fakeEmail"),
                Keys.TAB,
                ConfigReader.getProperty("fakePassword"),
                Keys.ENTER);

        // yanlis email ve yanlis password ile giris yapilamadigini test edelim

        //Yanlış email ve yanlış password ile giriş yapılamadığını test edelim
        String fakeEmail = ConfigReader.getProperty("fakeEmail");
        String fakePassword = ConfigReader.getProperty("fakePassword");
        rentalPage.userEmail.sendKeys(fakeEmail,Keys.TAB,fakePassword,Keys.ENTER);
        Assert.assertTrue(rentalPage.verifyLogin.isDisplayed());
    }

    @Test
    public void test02() {

    }


    // Home Work 1
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
    // Home Work 2
    /*
    Name:
US101122_Negative_Login
Description:
Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
Acceptance Criteria:
Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
Error Message: email must be a valid email
Dogru email uzantisi girildiğinde hata mesajı alınmamalı
https://email-verify.my-addr.com/list-of-most-popularemail-
domains.php
    */
    // Home Work 3
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

}
