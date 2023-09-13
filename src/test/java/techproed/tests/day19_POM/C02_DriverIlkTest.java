package techproed.tests.day19_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C02_DriverIlkTest {
    @Test
    public void test01(){
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://facebook.com");
        Driver.getDriver().get("https://bestbuy.com");
    }
    @Test
    public void test02(){
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://facebook.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://bestbuy.com");
    }
}
