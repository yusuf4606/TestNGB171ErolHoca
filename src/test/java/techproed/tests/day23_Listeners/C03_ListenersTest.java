package techproed.tests.day23_Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(techproed.utilities.Listeners.class)
public class C03_ListenersTest {
    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void test01() {
        System.out.println("Test PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(1,1);
    }

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void test02() {
        System.out.println("Test FAILED");
        Assert.assertEquals(1,2);
    }
    /*
        Fail olan testlerden sonra IRetryAnalyzer arayüzü devreye girsin istersek
    @Test notasyonundan sonra parametre olarak retryAnalyzer = techproed.utilities.Listeners.class
    kullanırız
     */
}