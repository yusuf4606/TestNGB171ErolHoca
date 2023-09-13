package techproed.tests.day18_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Priority {
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
    @Test (priority = 2)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }@Test(priority = 1)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    /*
    TestNG de test methodlarimizi istedigimiz bir siralamada calistirmak istersek @Test notasyonundan sonra paramatere
     olarak (priority = num) yazarak siralayabiliriz. @Test notasyonuna sahip bir method'da priority default
     olarak sifirdir, eger priority yazilmazsa ilk o method calisir
     */
}
