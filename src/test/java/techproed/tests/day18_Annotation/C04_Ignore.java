package techproed.tests.day18_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_Ignore {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }
    @Ignore
    @Test (priority = 2)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }@Test(enabled = false,priority = 1)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    /*
        Eğer test methodlarımızdan o anlık çalıştırmak istemediğimiz methodlar olursa o methodun @Test notasyonunun
     üstüne yada yanına @Ignore notasyonu eklersek, eklenen methodu çalıştırmaz ve raporlarda bu Ignore edilen
     test methodunu skip(atlanmış) olarak görebilirsiniz.
        Ama @Test notasyonundan sonra parametre olarak enabled=false kullanırsak bu parametreyi kullanıdığımız
     methodda çalışmaz ve raporlara dahil olmaz
     */
}
