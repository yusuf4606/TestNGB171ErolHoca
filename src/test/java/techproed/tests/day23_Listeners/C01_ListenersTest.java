package techproed.tests.day23_Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(techproed.utilities.Listeners.class)

public class C01_ListenersTest {
    /*
    TestNG de Listeners kullanabilmek için utilities package'ı altında Listeners isminde bir class oluşturup,
bu class'ı ITestListener,IRetryAnalyzer, IAnnotationTransformer arayüzlerine implement ederiz.
    Test class'ımızda Listeners kullanabilmek için de class'dan önce @Listeners notasyonu eklememiz gerekir.
ve bu notasyona oluşturmuş olduğumuz Listeners class'ını argüman olarak tanımlamız gerekir.

 */
    @Test
    public void test01() {
        System.out.println("Test PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(1,1);
    }

    @Test
    public void test02() {
        System.out.println("Test FAILED");
        Assert.assertEquals(1,2);
    }
}
