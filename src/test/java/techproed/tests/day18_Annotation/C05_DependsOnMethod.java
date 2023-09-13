package techproed.tests.day18_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependsOnMethod {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() {
        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");
    }
    @Test(priority = 1, dependsOnMethods = "test01")//priority de eklenebilir
    public void test02() {
        //arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
    }
    @Test(priority = 2, dependsOnMethods = {"test01","test02"})
    public void test03() {
        //sonuç yazısının iphone içerdiğini test edelim
        String sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }
    /*
        DependsOnMethods @Test notasyonundan sonra test methoduna parametre olarak eklenir ve tekrar tekrar yazmamız
    gereken kodlar daha önce başka bir methodda yazılmış ise tekrar aynı kodları yazmak yerine dependsOnmethods
    parametresi ile bağlamak istediğimiz methodun adını yazarak tekrar kod yazmaktan kurtuluruz, Yukarıdaki örnekteki gibi...
     */
}