package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.OnlineVerifyEmailPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

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
https://email-verify.my-addr.com/list-of-most-popularemail-
domains.php
    */

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("onlineVerifyUrl"));

        // logine tikla
        OnlineVerifyEmailPage verifyEmailPage = new OnlineVerifyEmailPage();

        verifyEmailPage.loginButton.sendKeys(ConfigReader.getProperty("onlineVerifyYanlisEmail"), Keys.TAB);



    }
}
