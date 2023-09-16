package techproed.tests.day22_DataProvider_XmlFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class C08_DataProviderParallelTest {

    @DataProvider
    public static Object[][] veriler() {
        return new Object[][]{{"ford"},{"honda"},{"tesla"}};
    }

    @Test(dataProvider = "veriler",invocationCount = 2)
    // invocationcount = 2 dersek bu test iki defa calisir
    public void test01(String data) throws InterruptedException {
        //Google sayfasına gidelim
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com");
        Thread.sleep(3000);

        //DataProvider ile istediğimiz arac isimlerini aratalım
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        Thread.sleep(2000);
        aramaKutusu.sendKeys(data);
        Thread.sleep(2000);
        aramaKutusu.submit();

        //sayfayı kapatalım
        Thread.sleep(3000);
        driver.close();
    }
}