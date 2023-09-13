package techproed.tests.day20_PropertiesKullanimi;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PropertiesTest {
    @Test
    public void test01() {
        String url = ConfigReader.getProperty("amazonUrl");
        System.out.println("url = " + url);

        System.out.println(ConfigReader.getProperty("techproedUrl"));
        Driver.getDriver().get(url);
    }
}
