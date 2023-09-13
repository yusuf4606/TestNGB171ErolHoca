package techproed.tests.day19_POM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C01_SoftAssert {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void softAssert() throws InterruptedException {
        //1."http://zero.webappsecurity.com/" Adresine gidin başlığın Personal içerdiğini test edin
        driver.get("http://zero.webappsecurity.com/");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Personal"));

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button")).click();

        //3. Login kutusuna "username" yazin
        //4. Password kutusuna "password" yazin
        //5. Sign in tusuna basin
        WebElement loginKutusu = driver.findElement(By.xpath("(//input)[1]"));
        loginKutusu.sendKeys("username", Keys.TAB, "password", Keys.ENTER);
        driver.navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin başlığın Zero içerdiğini test edin
        driver.findElement(By.xpath("(//strong)[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
        softAssert.assertTrue(driver.getTitle().contains("Zero"));

        //7. "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("(//li//a)[16]")).click();

        //8. "Currency" drop down menusunden Eurozone'u secin
        WebElement currencyDropDown = driver.findElement(By.cssSelector("#pc_currency"));
        Select select = new Select(currencyDropDown);
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String seciliOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (euro)";
        softAssert.assertEquals(expectedOption,seciliOption,"Seçili option Uygun değil");

        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //edin ("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //(dollar)","Thailand (baht)")
        List<WebElement> dropdownList = select.getOptions();
        List<String> actualList = new ArrayList<>();
        for (WebElement w:dropdownList) {
            actualList.add(w.getText());
        }
        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One","Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
                "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"));

        Collections.sort(actualList);
        Collections.sort(expectedList);
        softAssert.assertEquals(expectedList,actualList,"Uyusmazlık var");
        System.out.println("Burasi Assertionlarda hata olsada çalışır");
        softAssert.assertAll();
        System.out.println("Burası Assertionda hata olursa çalışmaz");

    }

}